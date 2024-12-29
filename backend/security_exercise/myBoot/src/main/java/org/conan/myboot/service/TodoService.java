package org.conan.myboot.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.conan.myboot.domain.PageRequestDTO;
import org.conan.myboot.domain.PageResponseDTO;
import org.conan.myboot.domain.Todo;
import org.conan.myboot.domain.TodoDTO;
import org.conan.myboot.repository.TodoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class TodoService {
    private final ModelMapper modelMapper;
    private final TodoRepository todoRepository;

    public List<Todo> getList() {
        return todoRepository.findAll();
    }

    public Integer write(TodoDTO todoDTO) {
        log.info("---------------------");
        Todo todo = modelMapper.map(todoDTO, Todo.class);
        return todoRepository.save(todo).getTno();
    }

    public TodoDTO read(Integer tno) {
        Optional<Todo> result = todoRepository.findById(tno);
        Todo todo = result.orElseThrow();
        TodoDTO dto = modelMapper.map(todo, TodoDTO.class);
        return dto;
    }

    public void modify(TodoDTO todoDTO) {
        Optional<Todo> result = todoRepository.findById(todoDTO.getTno());
        Todo todo = result.orElseThrow();
        todo.setTitle(todoDTO.getTitle());
        todo.setDueDate(todoDTO.getDueDate());
        todo.setComplete(todoDTO.isComplete());
        todoRepository.save(todo);
    }

    public void delete(Integer tno) {
        todoRepository.deleteById(tno);
    }

    public PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO) {
        Pageable pageable = PageRequest.of(
                pageRequestDTO.getPage() - 1,
                pageRequestDTO.getSize(),
                Sort.by("tno").descending()
        );
        Page<Todo> result = todoRepository.findAll(pageable);
        List<TodoDTO> dtoList = result.getContent().stream()
                .map(todo -> modelMapper.map(todo, TodoDTO.class))
                .collect(Collectors.toList());
        long totalCount = result.getTotalElements();
        PageResponseDTO<TodoDTO> responseDTO = PageResponseDTO.<TodoDTO>withAll()
                .dtoList(dtoList)
                .pageRequestDTO(pageRequestDTO)
                .totalCount(totalCount)
                .build();
        return responseDTO;
    }

}
