package com.kood.Todo.Config;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfig {
	
//	@Bean
//	public InMemoryUserDetailsManager configUserDetails (){
//		UserDetails u=User.withDefaultPasswordEncoder()
//		.username("kood")
//		.password("kood")
//		.roles("USER","Admin")
//		.build();
//		return new InMemoryUserDetailsManager(u);
//	}

	@Bean
	public InMemoryUserDetailsManager configUserDetails (){
		
		UserDetails kood = createNewUser("kood","kood");
		UserDetails medo = createNewUser("medo","medo");
		
		return new InMemoryUserDetailsManager(kood,medo);
	}
	private UserDetails createNewUser(String username, String pass) {
		Function<String,String> passEncode = input-> passEncoder().encode(input);
		return User.builder()
				.passwordEncoder(passEncode)
		.username(username)
		.password(pass)
		.roles("USER","Admin")
		.build();
	}
	@Bean
	public PasswordEncoder passEncoder() { 
		return new BCryptPasswordEncoder();
	}  
	
	
	@Bean
	public SecurityFilterChain filter(HttpSecurity sec) throws Exception {
		sec.authorizeHttpRequests(
				auth->auth.anyRequest().authenticated());
		sec.formLogin(withDefaults());
		sec.csrf().disable();
		sec.headers().frameOptions().disable();
		return sec.build();
	}
}
