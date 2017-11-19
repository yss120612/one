package com.yss1.one;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yss1.one.calc.AS400Data;

@Controller
public class Lcontroller {

	@RequestMapping(value= {"/login"})
	public String login1(Model model,@RequestParam(value="error",required=false) String error,@RequestParam(value="logout",required=false) String logout) {
		if (error!=null)
		{
			model.addAttribute("error","Имя или пароль не верны!");
			model.addAttribute("username","");
			model.addAttribute("password","");
		}
		if (logout!=null)
		{
			model.addAttribute("messa","Выход успешно осуществлен!");
			model.addAttribute("username","");
			model.addAttribute("password","");
		}
		
		//model.addAttribute("name", "Yhhhh");
		//request.setAttribute("fw", new FW(request));
		return "login";
	}
	
	@RequestMapping(value= {"/calc"})
	public String calc(Model model) throws SQLException {
//		AS400Data asd=new AS400Data();
//		asd.load("049711721");
//		model.addAttribute("rest", asd.getRes());
		return "start";
	}
	
	
	
//	@RequestMapping(path="/one/login")
//	public String login2(Model model,String error,String logout) {
//		if (error!=null)
//		{
//			model.addAttribute("error","Имя или пароль не верны!");
//		}
//		if (logout!=null)
//		{
//			model.addAttribute("messa","Выход успешно осуществлен!");
//		}
//		
//		//model.addAttribute("name", "Yhhhh");
//		return "login";
//	}
	
//	
//	@RequestMapping(path="/login",method = RequestMethod.POST)
//	public String login2(Model model) {
//		model.addAttribute("name", "Yhhhh");
//		return "/";
//	}
	
}
