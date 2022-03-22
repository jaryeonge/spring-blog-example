package org.example.blog.service;

import org.example.blog.model.User;
import org.example.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// 서비스를 사용하는 이유
// 트랜잭션 관리
// 서비스의 의미
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void join(User user) {
        userRepository.save(user);
    }

    /*
    @Transactional(readOnly = true) // Select 할 때 트랜잭션 시작, 서비스 종료시에 트랜잭션 종료 (정합성)
    public User login(User user) {
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
    */
}
