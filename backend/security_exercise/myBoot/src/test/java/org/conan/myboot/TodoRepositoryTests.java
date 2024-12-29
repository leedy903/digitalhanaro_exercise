package org.conan.myboot;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.conan.myboot.domain.Todo;
import org.conan.myboot.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class TodoRepositoryTests {
    @Autowired
    TodoRepository todoRepository;

    @Test
    public void testClass() {
        log.info(todoRepository.getClass().getName());
    }

    @Test
    public void testInsertDummies() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Todo todo = Todo.builder()
                    .title("Sample ..." + i)
                    .writer("Sample writer")
                    .complete(false)
                    .dueDate(LocalDate.of(2024, 11, 28))
                    .build();
            todoRepository.save(todo);
        });
    }

    @Test
    public void testSelect() {
        Integer tno = 10;
        Optional<Todo> result = todoRepository.findById(tno);
        log.info("==========================");
        if (result.isPresent()) {
            Todo todo = result.get();
            log.info(todo);
        }
    }

    @Transactional
    @Test
    public void testSelect2() {
        Integer tno = 1;
        Todo todo = todoRepository.getOne(tno);
        log.info("================================");
        log.info(todo);
    }

    @Test
    public void testUpdate() {
        Todo todo = Todo.builder()
                .tno(1)
                .title("Update Title")
                .writer("Update writer")
                .complete(true)
                .dueDate(LocalDate.of(2024, 11, 28))
                .build();
        log.info(todoRepository.save(todo));
    }

    @Test
    public void testDelete() {
        Integer tno = 5;
        todoRepository.deleteById(tno);
    }

    @Test
    public void testPageDefault() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<Todo> result = todoRepository.findAll(pageable);
        log.info(result);

        log.info("--------------------");
        log.info("Total Pages : " + result.getTotalPages());
        log.info("Total Count : " + result.getTotalElements());
        log.info("Page Number : " + result.getNumber());
        log.info("Page Size : " + result.getSize());
        log.info("has Next Page? : " + result.hasNext());
        log.info("first Page? : " + result.isFirst());
    }

    @Test
    public void testPaging() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("tno").descending());
        Page<Todo> result = todoRepository.findAll(pageable);
        log.info(result.getTotalElements());
        result.getContent().stream().forEach(todo -> log.info(todo));
    }

    @Test
    public void testSort() {
        Sort sort1 = Sort.by("tno").descending();
        Pageable pageable = PageRequest.of(0, 10, sort1);
        Page<Todo> result = todoRepository.findAll(pageable);
        result.get().forEach(todo -> {
            log.info(todo);
        });
    }
}
