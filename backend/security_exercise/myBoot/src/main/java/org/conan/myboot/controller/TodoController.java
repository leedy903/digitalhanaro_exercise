package org.conan.myboot.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.conan.myboot.domain.PageRequestDTO;
import org.conan.myboot.domain.PageResponseDTO;
import org.conan.myboot.domain.Todo;
import org.conan.myboot.domain.TodoDTO;
import org.conan.myboot.repository.TodoRepository;
import org.conan.myboot.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@RestController
@Log4j2
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class TodoController {
    private final TodoRepository todoRepository;
    private final TodoService todoService;

    @GetMapping("/{tno}")
    public TodoDTO get(@PathVariable(name="tno") Integer tno) {
        return todoService.read(tno);
    }

    @PutMapping("/{tno}")
    public Map<String, String> modify(
            @PathVariable(name = "tno") Integer tno,
            @RequestBody TodoDTO todoDTO
    ) {
        todoDTO.setTno(tno);
        log.info("Modify : " + todoDTO);
        todoService.modify(todoDTO);
        return Map.of("RESULT", "SUCCESS");
    }

    @GetMapping("/list")
    public PageResponseDTO<TodoDTO> List(PageRequestDTO pageRequestDTO) {
        return todoService.list(pageRequestDTO);
    }

    @GetMapping("/create")
    public String getCreate(Model model) {
        Todo todo = new Todo();
        model.addAttribute("todo", todo);
        return "todo/create";
    }

    @PostMapping("/create")
    public String postCreate(TodoDTO todo, RedirectAttributes redirectAttributes) {
        System.out.println(todo);
        todoService.write(todo);
        redirectAttributes.addFlashAttribute("result", todo.getTno());
        return "redirect:/todo/list";
    }

    @PostMapping("/")
    public Map<String, Integer> write(@RequestBody TodoDTO todoDTO) {
        log.info("TodoDTO : " + todoDTO);
        Integer tno = todoService.write(todoDTO);
        return Map.of("TNO", tno);
    }

    @GetMapping("/update")
    public String getUpdate(@RequestParam("tno") Integer tno, Model model) {
        TodoDTO todo = todoService.read(tno);
        model.addAttribute("todo", todo);
        return "todo/update";
    }

    @PostMapping("/update")
    public String postUpdate(TodoDTO todo) {
        System.out.println(todo);
        todoService.modify(todo);
        return "redirect:/todo/list";
    }

    @DeleteMapping("/{tno}")
    public Map<String, String> remove(@PathVariable(name = "tno") Integer tno) {
        log.info("Remove : " + tno);
        todoService.delete(tno);
        return Map.of("RESULT", "SUCCESS");
    }
}
