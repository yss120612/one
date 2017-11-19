package com.yss1.one;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.yss1.one.models.User;

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
		//String sql = "SELECT articleId, title, category FROM articles";
		Authentication au=SecurityContextHolder.getContext().getAuthentication();
		if (au.isAuthenticated())
		{
		model.addAttribute("name", ((User)au.getPrincipal()).getUsername());
		}
		model.addAttribute("auth", au.isAuthenticated()+"");
		return "start";
	}
	
//	@RequestMapping("/")
//	public String index(Model model,@RequestParam(value="name", required=false, defaultValue="World") String name) {
//		String sql = "SELECT articleId, title, category FROM articles";
//		Authentication au=SecurityContextHolder.getContext().getAuthentication();
//		
//		model.addAttribute("name", name);
//		model.addAttribute("auth", au.isAuthenticated()+"");
//		return "index";
//	}
	
	/*@RequestMapping("/login")
	public String login(Model model) {
		//String sql = "SELECT articleId, title, category FROM articles";
	    
		   
		//model.addAttribute("name", name);
		return "login";
	}*/
	
//	@RequestMapping(value = "/css/**", method = RequestMethod.GET)
//    public ModelAndView resources1() {
//        return null;
//    }
//	
//	@RequestMapping(value = "/js/**", method = RequestMethod.GET)
//    public ModelAndView resources2() {
//        return null;
//    }
//	
//	@RequestMapping(value = "/fonts/**", method = RequestMethod.GET)
//    public ModelAndView resources3() {
//        return null;
//    }
}
