package org.conan.mysecurity.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.conan.mysecurity.dto.PageRequestDTO;
import org.conan.mysecurity.dto.PageResponseDTO;
import org.conan.mysecurity.dto.TodoDTO;
import org.conan.mysecurity.service.TodoService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/todo")
public class TodoController {
//    private final TodoService service;
//    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
//    @GetMapping("/list")
//    public PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO) {
//        return todoService.list(pageRequestDTO);
//    }
}
