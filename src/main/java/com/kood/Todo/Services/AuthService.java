package com.kood.Todo.Services;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
	//Auth simulation
	public boolean authenticate(String name,String pass) {
		return name.equalsIgnoreCase("kood") && pass.equalsIgnoreCase("1234");
	}
}
