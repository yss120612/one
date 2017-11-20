package com.yss1.one;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yss1.one.calc.AS400Data;
import com.yss1.one.dao.UserDao;
import com.yss1.one.models.User;

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
		AS400Data asd=new AS400Data();
		String err=asd.load("049711721");
		Authentication au=SecurityContextHolder.getContext().getAuthentication();
		if (au.isAuthenticated())
		{
			model.addAttribute("name", ((User)au.getPrincipal()).getUsername());
		}
		model.addAttribute("rest", asd.getRes());
		model.addAttribute("err", err);
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
			result=ud.changePassword(u, lpo, lpn);	
		}
		
		if (result.isEmpty())
		{
			model.addAttribute("messa","Пароль успешно сменен");
			
		}
		else {
			model.addAttribute("error",result);
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
