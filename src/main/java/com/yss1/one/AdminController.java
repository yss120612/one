package com.yss1.one;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping(value= {"/useradd"})
	public String useraddGET(Model model)
	{
		//model.addAttribute("name", WebUtils.getLogin());
		model.addAttribute("titleform", "Создание пользователя");
		model.addAttribute("action","add");
		model.addAttribute("access",true);
		model.addAttribute("roles",rd.getRoleList());
		return "user";
	}
	
	@PostMapping(value= {"/useradd"})
	public ModelAndView useraddPOST(Model model,@RequestParam(value="username",required=true) String username,
										  @RequestParam(value="password",required=true) String password,
										  @RequestParam(value="password2",required=true) String password2,
										  @RequestParam(value="uroles",required=false,defaultValue="") String  roles,
										  @RequestParam(value="access",required=false,defaultValue="false") boolean acc)
	{
		
		String error="";
		if (!password.equals(password2))
		{
			error="Пароли не совпадают!";
		}
		
		if (password.length()<4)
		{
			error=(error.isEmpty())?"Пароли менее 4х символов!":error+"<br>Пароли менее 4х символов!";
		}
		
		User us=ud.getUserByName("");
		if (us!=null)
		{
			error=(error.isEmpty())?"Пользователь "+username+" уже существует":error+"<br>Пользователь "+username+" уже существует";
		}
		
		if (!error.isEmpty()) {
			model.addAttribute("err",error);
			model.addAttribute("action","add");
			model.addAttribute("titleform", "Создание пользователя");
			model.addAttribute("roles",rd.getRoleList());
			return new ModelAndView("redirect:/useradd", (Map<String, ?>) model);
		}
		us=ud.addUser(username, password, acc);
		for (String ro:roles.split(","))
		{
			us.addRole(rd.findRoleByName(ro));
		}
		ud.saveUser(us);
		
		return new ModelAndView("redirect:/userslist");
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
