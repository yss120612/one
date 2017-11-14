package com.yss1.one;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Lcontroller {

	@RequestMapping(path="/login")
	public String login1(Model model,String error,String logout) {
		if (error!=null)
		{
			model.addAttribute("error","Имя или пароль не верны!");
		}
		if (logout!=null)
		{
			model.addAttribute("messa","Выход успешно осуществлен!");
		}
		
		//model.addAttribute("name", "Yhhhh");
		return "login";
	}
//	
//	@RequestMapping(path="/login",method = RequestMethod.POST)
//	public String login2(Model model) {
//		model.addAttribute("name", "Yhhhh");
//		return "/";
//	}
	
}
