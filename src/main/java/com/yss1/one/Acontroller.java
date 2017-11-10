package com.yss1.one;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Acontroller {
	
	@InitBinder
	public void initBind()
	{
		ds1=(DataSource)aCtx.getBean("postgressDS");
	}
	@Autowired
	ApplicationContext aCtx;
	DataSource ds1;
	
	@RequestMapping("/")
	public String index(Model model,@RequestParam(value="name", required=false, defaultValue="World") String name) {
		String sql = "SELECT articleId, title, category FROM articles";
	    
		   
		model.addAttribute("name", name);
		return "index";
	}
	
	
	@RequestMapping("/login")
	public String login(Model model) {
		//String sql = "SELECT articleId, title, category FROM articles";
	    
		   
		//model.addAttribute("name", name);
		return "login";
	}
	
}
