package com.example.firstproject.models.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
//@Table(name = "member")  // oracle사용시에 user라는 이름은 이미 사용하기 때문에 테이블 이름을 member로 교체
public class User {
    @Id     // 기본키(엔티티의 대표값 지정)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 자동 생성 추가
    private int id;
    private String username;
    private String password;
    private String email;
    private String role;    // ROLE_USER, ROLE_ADMIN, ROLE_MANAGER

    private String provider;   // GOOGLE, NAVER, KAKAO
    private String providerId; // 각각의 provider사의 id(google -> sub, naver -> ?, kakao -> ?)
    @CreationTimestamp
    private Timestamp createDate;
}
