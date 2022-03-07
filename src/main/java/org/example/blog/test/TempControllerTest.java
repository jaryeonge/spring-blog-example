package org.example.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {

    @GetMapping("/temp/home")
    public String tempHome() {
        System.out.println("tempHome()");
        // 파일리턴 기본경로: src/main/resources/static/home.html
        return "/home.html";
    }

    @GetMapping("/temp/img")
    public String tempImg() {
        return "/test.png";
    }

    // jsp 는 정적파일이 아님!
    @GetMapping("/temp/jsp")
    public String tempJsp() {
        // prefix: /WEB-INF/views/
        // suffix: .jsp
        // 풀네임: /WEB-INF/views/test.jsp
        return "test";
   }
}