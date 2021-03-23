package com.my.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {
	
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("tempHome()");
		return "/home.html";
	}
	
	@GetMapping("/temp/jsp")
	public String tempImage() {
		return "////temp.jsp";
//		application 설정 때문에  경로 설정이 알아서 된다.
	}
}
