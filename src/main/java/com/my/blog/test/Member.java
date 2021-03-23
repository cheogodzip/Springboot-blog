package com.my.blog.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//@Getter 게터 메소드 생성
//@Setter 세터 메소드 생성
//@RequiredArgsConstructor // final 값을 받는 생성자 만듦
@Data
//@AllArgsConstructor // 모든 필드 값을 받는 생성자
@NoArgsConstructor // 빈 디폴드 생성자
public class Member {
	private  int id; // 불변성 유지를 위해 final로 
	private  String username;
	private String password;
	private  String email;
	
	@Builder
	public Member(int id, String username, String password, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
}
