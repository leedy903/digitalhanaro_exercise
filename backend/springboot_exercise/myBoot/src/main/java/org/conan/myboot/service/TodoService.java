package org.conan.myboot.service;

import lombok.extern.log4j.Log4j2;
import org.conan.myboot.domain.Todo;
import org.conan.myboot.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getList() {
        log.info("service getList");
        return todoRepository.findAll();
    }

    public void write(Todo todo) {
        log.info("service write");
        todoRepository.save(todo);
    }

    public Todo read(Long tno) {
        log.info("service read");
        Optional<Todo> todo = Optional.of(todoRepository.findById(tno).orElse(new Todo()));
        return todo.get();

    }

    public void modify(Todo todo) {
        log.info("service modify");
        if(todoRepository.findById(todo.getTno()).isPresent()) {
            todoRepository.save(todo);
        }
    }

    public void remove(Long tno) {
        log.info("service remove");
        if(todoRepository.findById(tno).isPresent()) {
            todoRepository.deleteById(tno);
        }
    }
}
