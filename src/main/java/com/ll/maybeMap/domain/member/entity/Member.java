package com.ll.maybeMap.domain.member.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    private String profile;

    private String phone;

    private LocalDate birthday;
}