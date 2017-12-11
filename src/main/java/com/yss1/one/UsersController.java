package com.yss1.one;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itextpdf.text.DocumentException;
import com.yss1.one.dao.AS400Dao;
import com.yss1.one.dao.MainDao;
import com.yss1.one.dao.UserDao;
import com.yss1.one.models.Man;
import com.yss1.one.util.ApplicationContextUtil;
import com.yss1.one.util.PdfFactory;
import com.yss1.one.util.WebUtils;

@Controller
public class UsersController {
	
	@InitBinder
	public void initBind()
	{
	//	ds1=(DataSource)aCtx.getBean("postgressDS");
	}
//	@Autowired
//	ApplicationContext aCtx;
//	DataSource ds1;
//
//	private String getLogin()
//	{	
//		Authentication au=SecurityContextHolder.getContext().getAuthentication();
//		if (au.isAuthenticated())
//		{
//		return ((User)au.getPrincipal()).getUsername();
//		}
//		return null;
//	}
	
	@Autowired
	UserDao ud;
	
	@Autowired
	PdfFactory pdfFactory;
	
	
	@Autowired
	MainDao mainDao;
	
	
	@RequestMapping("/")
	public String index(Model model,@RequestParam(value="name", required=false, defaultValue="World") String name) {
		model.addAttribute("name", WebUtils.getLogin());
		model.addAttribute("rest", WebUtils.myRoles(", "));
		return "start";
	}
	
	
	@RequestMapping("/test")
	public String test(Model model) throws DocumentException, IOException {
		String test="";
		model.addAttribute("name", WebUtils.getLogin());
		try {
			pdfFactory.makeTest("Тестовый"+new Date().getTime());	
		}
		catch(Exception ex){
			model.addAttribute("err", ex.getMessage());
		}
		model.addAttribute("rest", test);
		return "start";
	}
	
	
	@GetMapping(value= {"/calc"})
	public String calcGet(Model model) throws SQLException {
		//model.addAttribute("rest", asd.getRes());
		//model.addAttribute("err", err);
		model.addAttribute("name", WebUtils.getLogin());
		model.addAttribute("apage", "calc");
		return "start";
	}
	
	
	@PostMapping(value= {"/calc"})
	public String calcPost(Model model,@RequestParam(value="snils", required=true) String snils) throws SQLException {
		//AS400Dao asd=new AS400Dao();
		Man man=null;
		try {
			man=mainDao.calculate(snils,0);
		} catch (DocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				//asd.load(snils);
		//String err=asd.getErr();
		
		model.addAttribute("name", WebUtils.getLogin());
		//model.addAttribute("rest", "OK");
		if (mainDao.getError().isEmpty())
		{
			model.addAttribute("man", man);
			model.addAttribute("res", man.getRes());
		}
		else
		{
			model.addAttribute("err", mainDao.getError());	
		}
		
		model.addAttribute("apage", "calcres");
		
		return "start";
	}
	
}
