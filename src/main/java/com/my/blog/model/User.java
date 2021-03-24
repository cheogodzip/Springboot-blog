package com.my.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // 게터,세터 롬복
@NoArgsConstructor  // 디폴트 생성자
@AllArgsConstructor // 모든 필드 생성자
@Builder // 빌터 패턴
@Entity //이 클래스가 MySql에 테이블이 생성된다.
//@DynamicInsert // insert할 때 null인 필드는 제외하고 쿼리를 날린다.
public class User {

	@Id  // pk
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; // 시퀀스, auto_increment로 올릴 것이다.
	
	@Column(nullable = false, length = 30)
	private String username; // 진짜 아이디
	
	@Column(nullable = false, length = 100) //암호화하기 위해 길이를 길게 한다.
	private String password;

	@Column(nullable = false, length = 50)
	private String email;
	
//	@ColumnDefault("'user'")
//	DB는 RolyType이 없어 어노테이션을 붙인다.
	@Enumerated(EnumType.STRING)
	private RoleType  role; // Enum을 사용한다. ADMIN, USER
	
	@CreationTimestamp // 시간이 자동으로 입력됨
	private Timestamp createDate; 

}
