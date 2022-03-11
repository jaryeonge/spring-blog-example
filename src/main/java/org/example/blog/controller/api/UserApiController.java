package org.example.blog.controller.api;

import org.example.blog.dto.ResponseDto;
import org.example.blog.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user) {
        System.out.println("UserApiController: save 호출됨");
        return new ResponseDto<>(HttpStatus.OK, 1);
    }
}
