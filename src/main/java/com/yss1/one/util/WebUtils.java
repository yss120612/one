package com.yss1.one.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.yss1.one.models.User;

public class WebUtils {
	
public static String getLogin() {
	Authentication au=SecurityContextHolder.getContext().getAuthentication();
	if (au.isAuthenticated())
	{
	return ((User)au.getPrincipal()).getUsername();
	}
	return null;
}

public static boolean hasRole(String rn) {
	Authentication au=SecurityContextHolder.getContext().getAuthentication();
	if (au.isAuthenticated())
	{
		User u=(User)au.getPrincipal();
		for (GrantedAuthority ro: u.getAuthorities())
		{
			if (ro.getAuthority().equals(rn)) return true;
		}
	}
	return false;
}

}
