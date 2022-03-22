package org.example.blog.controller.api;

import org.example.blog.dto.ResponseDto;
import org.example.blog.model.User;
import org.example.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;

    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> save(@RequestBody User user) {
        System.out.println("UserApiController: save 호출됨");
        userService.join(user);
        return new ResponseDto<>(HttpStatus.OK.value(), 1);
    }

    /*
    @PostMapping("/api/user/login")
    public ResponseDto<Integer> login(@RequestBody User user, HttpSession session) {
        System.out.println("UserApiController: login 호출됨");
        User principal = userService.login(user); // principal: 접근주체

        if (principal != null) {
            session.setAttribute("principal", principal);
        }
        return new ResponseDto<>(HttpStatus.OK.value(), 1);
    }
    */
}
