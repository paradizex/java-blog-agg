package au.com.pun.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class IndexController {
	@RequestMapping("/index")
	public String index(){
		//return "/WEB-INF/jsp/index.jsp";
		return "index"; // corresponds to /WEB-INF/def/general.xml		<definition name="index">
	}

}
