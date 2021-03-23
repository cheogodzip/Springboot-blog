package com.my.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // 게터,세터 롬복
@NoArgsConstructor  // 디폴트 생성자
@AllArgsConstructor // 모든 필드 생성자
@Builder // 빌터 패턴
@Entity
public class Board {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column (nullable = false, length=100)
	private String title;
	
	@Lob
	private String content; // 섬머노트 라이브러리를  사용할 거다. -> html 태그를 사용하기 때문에 Lob으로 걸어준다.
	
	@ColumnDefault("0")
	private int count; // 조회수
	
	@ManyToOne// N : 1 -> Board : User -> 하나의 user는 여러 Board를 작성할 수 있다.
	@JoinColumn(name="userId") // 실제 테이블에는 userId로 저장된다.
	private User user; // DB는 오브젝트를 저장할 수 없으니까 FK(ForeignKey)를 사용한다.
	// ORM을 이용하면 객체 테이블을 따로 만든다.
	
	@CreationTimestamp
	private Timestamp createDate;
}
