package org.example.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더 패턴!!
// ORM -> Java(다른언어 포함) Object -> 테이블로 매핑해주는 기술
// @DynamicInsert // insert 시에 null 인 필드를 제외시켜 준다.
@Entity // User 클래스가 MYSQL 에 테이블로 생성이 된다.
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
    private int id;

    @Column(nullable = false, length = 30)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    // @ColumnDefault("'user'")
    @Enumerated(EnumType.STRING)
    private RoleType role; // Enum 을 쓰는 것이 좋다. // admin, user, manager

    @CreationTimestamp // 시간 자동입력
    private Timestamp createDate;
}
