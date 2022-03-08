package org.example.blog.test;

import org.example.blog.model.RoleType;
import org.example.blog.model.User;
import org.example.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DummyControllerTest {

    @Autowired // 의존성 주입
    private UserRepository userRepository;

    // dirty checking
    // 1차 캐시에 있는 객체의 변경을 감지해서 자동 DB 업데이트
    @Transactional // 함수 종료시에 자동 commit 이 된다.
    @PutMapping("/dummy/user/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User requestUser) {
        System.out.println("id: " + requestUser.getId());
        System.out.println("password: " + requestUser.getPassword());
        System.out.println("email: " + requestUser.getEmail());

        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("수정에 실패하였습니다."));
        user.setPassword(requestUser.getPassword());
        user.setEmail(requestUser.getEmail());

        // save 함수는 id 를 전달하지 않으면 insert 를 해주고
        // save 함수는 id 를 전달하면 해당 id 에 대한 데이터가 있으면 update 를 해주고
        // save 함수는 id 를 전달하면 해당 id 에 대한 데이터가 없으면 insert 를 한다.
        // userRepository.save(user);
        return null;
    }

    @PostMapping("/dummy/join")
    public String join(@RequestBody User user) {
        System.out.println("id: " + user.getId());
        System.out.println("username: " + user.getUsername());
        System.out.println("password: " + user.getPassword());
        System.out.println("email: " + user.getEmail());
        System.out.println("role: " + user.getRole());
        System.out.println("createDate: " + user.getCreateDate());

        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }

    @GetMapping("/dummy/users")
    public List<User> list() {
        return userRepository.findAll();
    }

    @GetMapping("/dummy/user")
    public List<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<User> pagingUser =  userRepository.findAll(pageable);
        return pagingUser.getContent();
    }

    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id) {
        // Optional => User or Null
//        User user = userRepository.findById(id).get();
//        User user = userRepository.findById(id).orElseGet(new Supplier<User>() {
//            @Override
//            public User get() {
//                return new User();
//            }
//        });

//        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
//            @Override
//            public IllegalArgumentException get() {
//                return new IllegalArgumentException("해당 유저는 없습니다. id: " + id);
//            }
//        });

        // 요청: 웹브라우저
        // user 객체 = 자바 오브젝트
        // 변환 (웹브라우저가 이해할 수 있는 데이터) -> json (Gson 라이브러리)
        // 스프링부트 = MessageConverter 응답시에 자동 작동
        // 만약에 자바 오브젝트를 리턴하게 되면 MessageConverter 가 Jackson 라이브러리를 호출해서
        // user 오브젝트를 json 으로 변환해서 브라우저에게 던저 준다.
        // lambda
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저는 없습니다. id: " + id));
    }
}
