package com.yss1.one;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yss1.one.dao.AS400Dao;
import com.yss1.one.dao.UserDao;
import com.yss1.one.models.Man;
import com.yss1.one.util.ApplicationContextUtil;
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
	
	@RequestMapping("/")
	public String index(Model model,@RequestParam(value="name", required=false, defaultValue="World") String name) {
		model.addAttribute("name", WebUtils.getLogin());
		model.addAttribute("rest", "home");
		return "start";
	}
	
	
	@RequestMapping("/test")
	public String test(Model model) {
		String test="";
		model.addAttribute("name", WebUtils.getLogin());
		if (ApplicationContextUtil.getApplicationContext()==null)
		{
			test="context is null!!";
		}
		else
		{
			test = "context exist!";
		}
		model.addAttribute("rest", test);
		return "start";
	}
	
	
	@RequestMapping(value= {"/calc"})
	public String calc(Model model,@RequestParam(value="snils", required=false, defaultValue="049711721") String snils) throws SQLException {
		AS400Dao asd=new AS400Dao();
		String err="";
		Man man=asd.load(snils,err);
		
		model.addAttribute("rest", asd.getRes());
		model.addAttribute("err", err);
		model.addAttribute("apage", "calc");
		return "start";
	}
}
