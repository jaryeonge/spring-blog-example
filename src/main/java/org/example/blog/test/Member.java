package org.example.blog.test;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Getter
// @Setter
@Data // Getter and Setter
// @AllArgsConstructor // 모든 변수 생성자
// @RequiredArgsConstructor // final 변수 생성자
@NoArgsConstructor
public class Member {

    private int id;
    private String username;
    private String password;
    private String email;

    @Builder // 생성자 순서 상관 x, 필드 실수 x
    public Member(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}