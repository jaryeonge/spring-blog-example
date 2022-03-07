package org.example.blog.test;

import org.springframework.web.bind.annotation.*;

// @Controller
// 사용자가 요청 -> 응답(HTML 파일)

// @RestController
// 사용자가 요청 -> 응답(Data)
@RestController
public class HttpControllerTest {

    private static final String TAG = "HttpControllerTest: ";

    @GetMapping("/http/lombok")
    public String lombokTest() {
        Member m = Member.builder().username("ssar").password("1234").email("ssar@nate.com").build();
        System.out.println(TAG + "getter: " + m.getUsername());
        m.setUsername("cos");
        System.out.println(TAG + "setter: " + m.getUsername());
        Member m1 = new Member(1, "ssar", "1234", "email");
        return "lombok test 완료";
    }

    @GetMapping("/http/get")
    public String getTest(Member m) {
        return "get 요청: " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
    }

    @PostMapping("/http/post")
    public String postTest(@RequestBody Member m) {
        return "post 요청: " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
    }

    @PutMapping("/http/put")
    public String putTest(@RequestBody Member m) {
        return "put 요청: " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
    }

    @DeleteMapping("/http/delete")
    public String deleteTest() {
        return "delete 요청";
    }
}