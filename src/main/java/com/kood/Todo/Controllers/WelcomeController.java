package com.kood.Todo.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kood.Todo.Services.AuthService;

@Controller
//@SessionAttributes("name")
public class WelcomeController {
//	private Logger log = LoggerFactory.getLogger(getClass());
/*
 @RequestMapping("/")
	public String hello(@RequestParam String name,ModelMap map) {
//		log.info("Hellooooo welcomeee"); 
		map.put("name", name);
		return "welcome";
	}
 * */	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String hello(ModelMap map) {
		map.put("userName", getLoggedUser());
		return "welcome";
	}
	
	private String getLoggedUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}
	
	
}
 