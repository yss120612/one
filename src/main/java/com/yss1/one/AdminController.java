package com.yss1.one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	private String erroradd="";
	
	@RequestMapping(value= {"/userslist"},method=RequestMethod.GET)
	public String uList(Model model,@RequestParam(value="error",required=false) String error,@RequestParam(value="logout",required=false) String logout) {
		model.addAttribute("name", WebUtils.getLogin());
		model.addAttribute("rest", "Список пользователей");
		model.addAttribute("apage","ulist");
		model.addAttribute("users",ud.getAllUsers());
		return "start";
	}
	
	@GetMapping(value= {"/useredit"})
	public String usereditGET(Model model,@RequestParam(value="userid",required=true) int id)
	{
		User u= ud.getUserById(id);
		model.addAttribute("titleform", "Изменение пользователя");
		model.addAttribute("action","edit");
		model.addAttribute("user",u);
		model.addAttribute("roles",rd.getRoleList());
		return "user";
	}
	
	@PostMapping(value= {"/useredit"})
	public String usereditPOST(Model model,@RequestParam(value="userid",required=true) int id,
										   @RequestParam(value="uroles",required=false) String  roles,
										   @RequestParam(value="access",required=false,defaultValue="false") boolean acc)
	{
		return "redirect:/userslist";
	}
	
	@GetMapping(value= {"/useradd"})
	public String useraddGET(Model model)
	{
		model.addAttribute("titleform", "Создание пользователя");
		model.addAttribute("action","add");
		if (!erroradd.isEmpty()) model.addAttribute("err",erroradd);
		model.addAttribute("access",true);
		model.addAttribute("roles",rd.getRoleList());
		erroradd="";
		return "user";
	}
	
	@PostMapping(value= {"/useradd"})
	public String useraddPOST(Model model,@RequestParam(value="username",required=true) String username,
										  @RequestParam(value="password",required=true) String password,
										  @RequestParam(value="password2",required=true) String password2,
										  @RequestParam(value="uroles",required=false) String  roles,
										  @RequestParam(value="access",required=false,defaultValue="false") boolean acc)
	{
		
		if (roles==null) roles="";
		erroradd="";
		if (!password.equals(password2))
		{
			erroradd="Пароли не совпадают!";
		}
		
		if (password.length()<4)
		{
			erroradd=(erroradd.isEmpty())?"Пароли менее 4х символов!":erroradd+"<br>Пароли менее 4х символов!";
		}
		
		User us=ud.addUser(username, password, acc,roles.split(","));
		if (us==null) {
			erroradd=(erroradd.isEmpty())?"Пользователь "+username+" уже существует":erroradd+"<br>Пользователь "+username+" уже существует";
		}
		
		if (!erroradd.isEmpty()) {
			return "redirect:/useradd";
		}
		
    	return "redirect:/userslist";
	}
	
	
	@PostMapping(value= {"/userdel"})
	public String userdelPOST(@RequestParam(value="userid",required=true) int id)
	{
		User us = ud.getUserById(id);
		
		ud.deleteUser(id);
		if (us.getUsername().equals(WebUtils.getLogin()))
		{
			return "redirect:/login?logout";
		}
		return "redirect:/userslist";
	}
	
}
