package org.conan.myboot.controller;

import lombok.extern.log4j.Log4j2;
import org.conan.myboot.domain.Todo;
import org.conan.myboot.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todo")
@Log4j2
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/list")
    public String list(Model model) {
        log.info("controller list");
        model.addAttribute("todos", todoService.getList());
        return "todo/list";
    }

    @GetMapping("/write")
    public String write() {
        log.info("controller write");
        return "todo/write";
    }

    @PostMapping("/write")
    public String write(Todo todo) {
        log.info("controller write " + todo);
        todoService.write(todo);
        return "redirect:/todo/list";
    }

    @GetMapping({"/read", "/modify"})
    public String read(Long tno, Model model) {
        log.info("controller read");
        model.addAttribute("todo", todoService.read(tno));
        return "todo/read";
    }

    @PostMapping("/modify")
    public String modify(Todo todo) {
        log.info("controller modify " + todo);
        todoService.modify(todo);
        return "redirect:/todo/list";
    }

    @GetMapping("/remove")
    public String remove(Long tno) {
        log.info("controller remove " + tno);
        todoService.remove(tno);
        return "redirect:/todo/list";
    }


}
