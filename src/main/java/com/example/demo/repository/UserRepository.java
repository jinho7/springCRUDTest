package com.example.demo.repository;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository; // 스프링에서 지원하는 레포지토리 클래스

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> { // 접근할 테이블 클래스, 프라이머리 키의 자료형
    public Optional<User> findUserByName(String name);
    public Optional<User> findUserByUserId(Long idx);
}
