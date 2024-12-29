package org.conan.myboot.repository;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.conan.myboot.domain.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class TodoRepositoryTest {
    @Autowired
    TodoRepository todoRepository;

    @Test
    void testInsert() {
        IntStream.range(0, 50).forEach(i -> {
            Todo todo = Todo.builder()
                    .title("title " + i)
                    .writer("writer " + i)
                    .complete(false)
                    .dueDate(LocalDate.of(2024, 11, 28))
                    .build();
            todoRepository.save(todo);
        });
    }

    @Test
    void testSelect() {
        Long tno = 1L;
        Optional<Todo> result = todoRepository.findById(tno);
        if (result.isPresent()) {
            Todo todo = result.get();
            log.info(todo);
        }
    }

//    @Transactional
//    @Test
//    void testSelect2() {
//        Long tno = 2L;
//        Todo todo = todoRepository.getOne(tno);
//        log.info("========================");
//        log.info(todo);
//    }
//
//    @Test
//    void testUpdate() {
//        Todo todo = Todo.builder()
//                .tno(3L)
//                .title("title update")
//                .writer("writer update")
//                .complete(true)
//                .dueDate(LocalDate.of(2024, 11, 28))
//                .build();
//        log.info(todoRepository.save(todo));
//    }

    @Test
    void testDelete() {
        Long tno = 5L;
        todoRepository.deleteById(tno);
    }
}