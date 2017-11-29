package com.yss1.one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yss1.one.dao.RoleDao;
import com.yss1.one.dao.UserDao;
import com.yss1.one.models.User;
import com.yss1.one.util.WebUtils;

@Controller
public class AdminController {

	@Autowired
	UserDao ud;
	
	@Autowired
	RoleDao rd;
	
	@RequestMapping(value= {"/userslist"},method=RequestMethod.GET)
	public String uList(Model model,@RequestParam(value="error",required=false) String error,@RequestParam(value="logout",required=false) String logout) {
		model.addAttribute("name", WebUtils.getLogin());
//		model.addAttribute("radmin",WebUtils.hasRole("ADMIN"));
//		model.addAttribute("ruser",WebUtils.hasRole("USER"));
		model.addAttribute("rest", "Список пользователей");
		model.addAttribute("apage","ulist");
		model.addAttribute("users",ud.getAllUsers());
		//model.addAttribute("isadmin",WebUtils.hasRole("ADMIN"));
		return "start";
	}
	
	@PostMapping(value= {"/useredit"})
	public String usereditPOST(Model model,@RequestParam(value="userid",required=true) int id)
	{
		model.addAttribute("name", WebUtils.getLogin());
		model.addAttribute("rest","useredit call");
		model.addAttribute("apage","home");
		
		return "start";
	}
	
	@PostMapping(value= {"/useradd"})
	public String useradd(Model model)
	{
		//model.addAttribute("name", WebUtils.getLogin());
		model.addAttribute("titleform", "Создание пользователя");
		model.addAttribute("action","add");
		model.addAttribute("roles",rd.getRoleList());
		return "user";
	}
	
	@PostMapping(value= {"/userdel"})
	public ModelAndView userdelPOST(Model model,@RequestParam(value="userid",required=true) int id)
	{
//		model.addAttribute("name", WebUtils.getLogin());
//		model.addAttribute("rest","userdel call");
//		model.addAttribute("apage","ulist");
		User us = ud.getUserById(id);
		
		ud.deleteUser(id);
		if (us.getUsername().equals(WebUtils.getLogin()))
		{
			return new ModelAndView("redirect:/login?logout");
		}
		return new ModelAndView("redirect:/userslist");
	}
	
	
	
	
}
