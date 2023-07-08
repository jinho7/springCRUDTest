package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor // 모든 요소들 생성자
@NoArgsConstructor // 초기화 없이 선언만.
// @RequiredArgsConstructor // 필요한 값만.
@Builder //
public class UserResponseDto {

    public String email;

    public String name;


}
