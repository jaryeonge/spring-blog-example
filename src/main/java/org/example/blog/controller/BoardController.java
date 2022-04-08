package org.example.blog.controller;

import org.example.blog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 컨트롤러에서 세션을 어떻게 찾는지?
    // @AuthenticationPrincipal PrincipalDetail principal
    // /WEB-INF/views/index.jsp
    @GetMapping({"","/"})
    public String index(Model model) {
        model.addAttribute("boards", boardService.list());
        return "index"; // viewResolver 작동, 모델의 정보를 들고 간다.
    }

    // USER 권한이 필요
    @GetMapping("/board/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }
}
