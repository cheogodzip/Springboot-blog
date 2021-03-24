package com.my.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.blog.model.User;

// DAO
// 자동으로 bean으로 등록된다. 따로 어노테이션을 붙이지 않아도 된다.
// @Repository 생략 가능.
public interface UserRepository extends JpaRepository<User, Integer>{
	
	
}
