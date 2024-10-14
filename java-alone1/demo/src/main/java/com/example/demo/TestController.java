package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    @GetMapping("/humanit")
    public String test1() {
    return "test1";
    }

    @GetMapping("/test2.do")
    public String test2() {
        return "test1";
    }

    @GetMapping("/board-list")
    public String boardList(Model model) {
        model.addAttribute( "k3", saveTitle);
        model.addAttribute( "k2", "테스트임");
        return "board-list";
    }

    @GetMapping("/board-detail")
    public String boardDetail() {
        return "board-detail";
    }

    @GetMapping("/board-insert")
    public String boardInsert() {
        return "board-insert";
    }

    @GetMapping("/board-delete")
    public String boardDelete() {
        return "board-delete";
    }

    @GetMapping("/board-update")
    public String boardUpdate() {
        return "board-update";
    }

    @GetMapping("/board/1")
    public String boardOne() {
        return "board-detail";
    }

    @GetMapping("/board/2")
    public String boardTwo() {
        return "board-detail";
    }

    @PostMapping("/board/{id}")
    public String boardDetailpath(@PathVariable int id, Model model) {
        model.addAttribute("a", id);
        return "board-detail";
    }

    private String saveTitle = "";
    private String saveWriter = "";
    private String saveContent = "";

    private List<String> saveTitleList = new ArrayList<>();

    @PostMapping("/board/insert")
    private String boardInsertData(String title, String writer, String content) {
        saveTitle = title;
        saveWriter = writer;
        saveContent = content;

        saveTitleList.add(title);
        return "redirect:/board-list";
    }
}
