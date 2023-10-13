package com.jspiders.SpringMvc1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.SpringMvc1.pojo.AdminPOJO;
import com.jspiders.SpringMvc1.service.AdminService;

import jakarta.servlet.http.HttpSession;
@Controller
public class AdminController {
	@Autowired
	private AdminService service;
	
	
//create Account PAge Controller 
	@GetMapping("/createAccount")
	public String createAccountPage(ModelMap map) {
		AdminPOJO pojo=service.getAdmin();
		if (pojo !=null) {
			map.addAttribute("msg", "Account already exists...!");
			return "Login";
			
		}
		return "CreateAccount";
		
	}
	//create Account Controller
	@PostMapping("/createAccount")
	public String createAccount(@RequestParam String username,@RequestParam String password,ModelMap map) {
		AdminPOJO pojo=service.createAccount(username,password);
		
		
		if (pojo!=null) {
			map.addAttribute("msg", "Account created succesfully");
			return "Login";
			
		}
		//failure
		map.addAttribute("msg", "account not created...!");
		return "Login";
		
	}
	@PostMapping("/login")
	public String login(@RequestParam String username,@RequestParam String password,ModelMap map,HttpSession session) {
		AdminPOJO pojo=service.login(username,password);
		
		if (pojo !=null) {
			session.setAttribute("login", pojo);
			session.setMaxInactiveInterval(1000);
			return "Home";
			
		}
		map.addAttribute("msg", "Invalid username or password");
		return "Login";
		
	}
//logout Controller
	@GetMapping("/logout")
	public String logout(ModelMap map ) {
	map.addAttribute("msg", "Logged out successfully");
		return "Login";
		}
}

