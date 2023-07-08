package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter // 도메인에는 Setter은 넣으면 안된다. 보안상 문제로
@Table(name = "user") // 페이지 이름 설정
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // 전략 설정 auto
    private Long userId; // Primary Key

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime creadted_at;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
