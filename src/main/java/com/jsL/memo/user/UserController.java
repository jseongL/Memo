package com.jsL.memo.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsL.memo.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	
	
	@GetMapping("/login-view")
	public String login() {
		return "user/login";
	}
	
	@GetMapping("/join-view")
	public String join() {
		return "user/join";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
