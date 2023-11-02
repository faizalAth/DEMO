package in.spring.ath.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import in.spring.ath.Repositories.EmployeeRepo;

@Controller
public class HomeController {

	@Autowired
	EmployeeRepo repo;
	
	@RequestMapping("home")
	public String openHomePage() {
		return "homePage";
	}
	
	@RequestMapping("allEmployees")
	public String allEmployees() {
		return "allEmployees";
	}
	
	@RequestMapping("login")
	public String openLoginPage() {
		return "login";
	}
}
