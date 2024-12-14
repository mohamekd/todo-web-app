package com.kood.Todo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kood.Todo.Services.AuthService;


@Controller
@SessionAttributes("name")
public class LoginController {
	/*
	 private Logger logger = LoggerFactory.getLogger(getClass());
	
	//urlReq?name=kood
	//to use reqParam(which is controller) on JSP(which is view) we need *MODEL* phase to map it
	@RequestMapping("login")
	public String login(@RequestParam String name, ModelMap map) {
		map.put("name", name);
		logger.info("Hello {},it is debug logger",name);
		return "login";
	}
	 */
/*
	@RequestMapping(value = "login",method = RequestMethod.GET)
	public String login() {
		return "login-page";
	}
	
	private AuthService authService;
	
	public LoginController(AuthService authService) {
		super();
		this.authService = authService;
	}

	@RequestMapping(value = "login" ,method = RequestMethod.POST)
	public String welcome(@RequestParam String name,@RequestParam String password,ModelMap map) {
		
		if (authService.authenticate(name, password)) {
			map.put("name",name);
			return "welcome";	
		}
		map.put("err","Invalid Credentials! Please Try Again");
			return "errlogin";
		
	}
	*/

}
