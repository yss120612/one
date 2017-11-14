package com.yss1.one;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Lcontroller {

	@RequestMapping(name="/login",method = RequestMethod.GET)
	public String login1(Model model) {
		model.addAttribute("name", "Yhhhh");
		return "login";
	}
	
	@RequestMapping(name="/login",method = RequestMethod.POST)
	public String login2(Model model) {
		model.addAttribute("name", "Yhhhh");
		return "/";
	}
	
}
