package au.com.pun.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import au.com.pun.spring.Service.UserService;
import au.com.pun.spring.entity.User;

@Controller
public class ShowUsersController {
	
	@Autowired
	UserService users;
	
	@ModelAttribute("user")
	public User getUserAtrribute(){
		return new User();
	}
	
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
	
	@RequestMapping("/register")
	public String showRegisteration(){
		
		return "user-register";
	} 
	
	@RequestMapping(value="register", method=RequestMethod.POST)
	public String doRegister(@ModelAttribute("user") User user){
		users.save(user); 
		return "redirect:/index.html";
	}
}
