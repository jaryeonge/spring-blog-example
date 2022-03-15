package org.example.blog.controller.api;

import org.example.blog.dto.ResponseDto;
import org.example.blog.model.RoleType;
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

    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user) {
        System.out.println("UserApiController: save 호출됨");
        user.setRole(RoleType.USER);
        userService.join(user);
        return new ResponseDto<>(HttpStatus.OK.value(), 1);
    }
}
