package com.kood.Todo.MVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TodoController {
	
	@RequestMapping("welcome")
	public String hello() {
		return "welcome";
	}
}
