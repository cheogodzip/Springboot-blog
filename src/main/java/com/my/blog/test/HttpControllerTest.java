package com.my.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 사용자 요청에 HTML을 응답하면 @Controller

// @RestController :  사용자가 요청에 대해 데이터를 응답한다.

@RestController
public class HttpControllerTest {
	
	private static final String TAG = "HttpControllerTest : ";
	
	@GetMapping("/http/lombok")
	public String lombokTest() {
		
		Member m = Member.builder().username("ssar").password("1234").email("ssar@naver.com").build();
		System.out.println(TAG + "getter : " + m.getUsername());
		m.setUsername("lkvber");
		System.out.println(TAG + "setter : " + m.getUsername());
		
		return "lombokTest 완료";
	}

	// http://localhost:8080/http/get
	@GetMapping("/http/get")
	public String getTest(Member m) { 
		// RequestParam 어노테이션을 통해 쿼리 스트링을 받을 수 있다.
		// 매개변수에 객체를 넣으면 알아서 쿼리스트링으로 들어온 변수,값과 객체의 필드를 매핑해준다.
		
		return "get 요청 : " +m.getId()  + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
	}
	
	// http://localhost:8080/http/post
	@PostMapping("/http/post")
	public String postTest(@RequestBody Member m) {
		// get요청과 마찬가지로 매개변수에 객체를 넣어 객체 필드값과 매치시킬 수도 있다. 대신 객체를 받을 때도 어노테이션 붙여야 한다. RequestBody
		// RequestBody 어노테이션으로 body의 입력값을 받을 수 있다.
		return "post 요청 : " +m.getId()  + ", " + m.getUsername();
//		return "post 요청 : " +m.getId()  + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
	}
	
//	body에 json 데이터가 있더라도 
//	헤더에 따라서 처리가 달라진다
//	마임타입을 text/plain이라고 하면 그냥 텍스트로 받아들이고
//	마임타입을 application/json 이라고 하면 json으로 받아서 파싱을 한다. 그래서 매핑을하고 컨트롤러가 객체와 이어준다.
//
//	이런 일을 스프링부트의 MessageConverter가 해준다.
	
	
	// http://localhost:8080/http/put
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put 요청: " +m.getId()  + ", " + m.getUsername() +", " + m.getPassword() +", " + m.getEmail();
	}
	
	// http://localhost:8080/http/delete
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
}
