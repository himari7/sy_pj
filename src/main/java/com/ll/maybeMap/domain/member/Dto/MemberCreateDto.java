package com.ll.maybeMap.domain.member.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MemberCreateDto {
    private String username;
    private String password;
    private String email;

}