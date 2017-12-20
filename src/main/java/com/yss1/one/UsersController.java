package com.yss1.one;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itextpdf.text.DocumentException;
import com.yss1.one.dao.MainDao;
import com.yss1.one.dao.ManDao;
import com.yss1.one.dao.SpravkaDao;
import com.yss1.one.dao.UserDao;
import com.yss1.one.models.Man;
import com.yss1.one.util.PdfFactory;
import com.yss1.one.util.WebUtils;

@Controller
public class UsersController {
	
	
	@Autowired
	UserDao ud;
	
	@Autowired
	PdfFactory pdfFactory;
	
	@Autowired
	ManDao manDao;
		
	@Autowired
	SpravkaDao sprDao;
	
	@Autowired
	MainDao mainDao;
	
	@RequestMapping("/")
	public String index(Model model,@RequestParam(value="name", required=false, defaultValue="World") String name) {
		model.addAttribute("name", WebUtils.getLogin());
		model.addAttribute("rest", "Начало");
		return "start";
	}
	
	
	@RequestMapping("/reslist")
	public String reslist(Model model){
		String us=WebUtils.getLogin();
		model.addAttribute("name", us);
		model.addAttribute("rest", "Список запросов "+us+" за последние 7 дней");
		model.addAttribute("qlist", sprDao.getResList(7,us));
		model.addAttribute("apage", "reslist");
		return "start";
	}
	
	
	@GetMapping(value= {"/load/{id}"})
	public String loadGet(Model model,@PathVariable("id") int id) throws SQLException {
		
		model.addAttribute("name", WebUtils.getLogin());
		model.addAttribute("apage", "load");
		Man man = manDao.restore(id);
		if (man==null) {
			model.addAttribute("err","Нет сохраненных данных для этого запроса!");
		}
		else {
			man.calcPens();
			model.addAttribute("man", man);
		}
		return "start";
	}
	
	@RequestMapping("/pdf/{vid}/{id}")
	public String getPdf(@PathVariable("id") int id,
						 @PathVariable("vid") int vid,
						  HttpServletResponse response) throws DocumentException, IOException {
			byte [] ba=vid==1?sprDao.getRasch(id):sprDao.getRasyasn(id);
				try {
					response.setHeader("Content-Disposition", "inline;filename=\""+(vid==1?"Rasyasnenya":"Raschet")+".pdf\"");
					OutputStream out = response.getOutputStream();
					response.setContentType("application/pdf");
					out.write(ba);
					out.flush();
					out.close();
				
				} catch (IOException e) {
					e.printStackTrace();
				
				}
				return null;
	}
	
	
	@GetMapping(value= {"/calc"})
	public String calcGet(Model model) throws SQLException {
		model.addAttribute("name", WebUtils.getLogin());
		model.addAttribute("apage", "calc");
		return "start";
	}
	
	
	@PostMapping(value= {"/calc"})
	public String calcPost(Model model,@RequestParam(value="snils", required=true) String snils) throws SQLException {

		Man man=null;
		try {
			man=mainDao.calculate(snils,0);
			model.addAttribute("userid", mainDao.getId());
		} catch (DocumentException | IOException e) {
					e.printStackTrace();
		}
		
		model.addAttribute("name", WebUtils.getLogin());
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
