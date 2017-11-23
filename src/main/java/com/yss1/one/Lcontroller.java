package com.yss1.one;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yss1.one.dao.UserDao;
import com.yss1.one.models.User;
import com.yss1.one.util.ApplicationContextUtil;
import com.yss1.one.util.WebUtils;

@Controller
public class Lcontroller {

	@Autowired
	ApplicationContext actx;
	
	@PostConstruct
	public void init()
	{
		ApplicationContextUtil acu=new ApplicationContextUtil();
		acu.setApplicationContext(actx);
	//	System.out.println("ACTX="+actx);
	}
	
	
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
		return "login";
	}
	
	
	@RequestMapping(value= {"/userslist"},method=RequestMethod.GET)
	public String uList(Model model,@RequestParam(value="error",required=false) String error,@RequestParam(value="logout",required=false) String logout) {
		model.addAttribute("name", WebUtils.getLogin());
		model.addAttribute("radmin",WebUtils.hasRole("ADMIN"));
		model.addAttribute("ruser",WebUtils.hasRole("USER"));
		model.addAttribute("rest", "Список пользователей");
		model.addAttribute("apage","ulist");
		model.addAttribute("users",ud.getAllUsers());
		//model.addAttribute("isadmin",WebUtils.hasRole("ADMIN"));
		return "start";
	}
	
	
	
	@RequestMapping(value= {"/chgpwd"},method = RequestMethod.GET)
	public String chgpwdGET(Model model) {
		Authentication au=SecurityContextHolder.getContext().getAuthentication();
		if (au.isAuthenticated())
		{
			model.addAttribute("name", ((User)au.getPrincipal()).getUsername());
		}
		return "chgpass";
	}
	
	@Autowired
	UserDao ud;
	
	@RequestMapping(value= {"/chgpwd"},method = RequestMethod.POST)
	public String chgpwdPOST(Model model,
							@RequestParam(value="password_old",required=true) String lpo,
							@RequestParam(value="password_new",required=true) String lpn,
							@RequestParam(value="password_new2",required=true) String lpn2) {
		User u=null;
		Authentication au=SecurityContextHolder.getContext().getAuthentication();
		String result="";
		
		if (au.isAuthenticated())
		{
			u=(User)au.getPrincipal();
			result=ud.changePassword(u.getUsername(), lpo, lpn);	
		}
		
		if (u!=null)
		{
			model.addAttribute("name",u.getUsername());
		}
		
		if (result.isEmpty())
		{
			model.addAttribute("rest","Пароль успешно сменен");
			
		}
		else {
			model.addAttribute("err",result);
		}
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
