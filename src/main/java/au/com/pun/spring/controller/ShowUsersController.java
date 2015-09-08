package au.com.pun.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import au.com.pun.spring.Service.UserService;

@Controller
public class ShowUsersController {
	
	@Autowired
	UserService users;
	
	@RequestMapping("/users")
	public String getUserData(Model model){
		
		model.addAttribute("userList", users.findAll());
		return "users";
	}
	
	@RequestMapping("/user/{id}")
	public String getUserDetail(Model model,@PathVariable int id ){
		model.addAttribute("user", users.findOneWithBlog(id));
		return "user-detail";
	}
	
	
}
