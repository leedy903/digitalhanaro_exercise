package org.conan.myboot.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.conan.myboot.domain.Memo;
import org.conan.myboot.domain.Board;
import org.conan.myboot.domain.QBoard;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class MemoRepositoryTest {
    @Autowired
    MemoRepository memoRepository;
    @Autowired
    private BoardRepository boardRepository;

    @Test
    void textClass() {
        log.info(memoRepository.getClass().getName());
    }

    @Test
    void testInsertDummies() {
        IntStream.range(1, 100).forEach(i -> {
            Memo memo = Memo.builder().memoText("Sample..." + i).build();
            memoRepository.save(memo);
        });
    }

    @Test
    void testSelect() {
        Long mno = 10L;
        Optional<Memo> result = memoRepository.findById(mno);
        log.info("===========================");
        if(result.isPresent()) {
            Memo memo = result.get();
            log.info(memo);
        }
    }

//    @Transactional
//    @Test
//    void testSelect2() {
//        Long mno = 8L;
//        Memo memo = memoRepository.getOne(mno);
//        log.info("===========================");
//        log.info(memo);
//    }
//
//    @Test
//    void testUpdate() {
//        Memo memo = Memo.builder().mno(8L).memoText("Update Text").build();
//        log.info(memoRepository.save(memo));
//    }

    @Test
    void testDelete() {
        Long mno = 5L;
        memoRepository.deleteById(mno);
    }

    @Test
    void testPageDefault() {
        PageRequest pageable = PageRequest.of(0, 5);
        Page<Memo> result = memoRepository.findAll(pageable);
        log.info(result);
        log.info("===================");
        log.info("Total pages: " + result.getTotalPages());
        log.info("Total count: " + result.getTotalElements());
        log.info("Page number: " + result.getNumber());
        log.info("Page size: " + result.getSize());
        log.info("Has next page?: " + result.hasNext());
        log.info("First page?: " + result.isFirst());
    }

    @Test
    void testSort() {
        Sort sort1 = Sort.by("mno").descending();
        Pageable pageable = PageRequest.of(0, 10, sort1);
        Page<Memo> result = memoRepository.findAll(pageable);
        result.get().forEach(log::info);
    }

    @Test
    void testQueryMethods() {
        List<Memo> list = memoRepository.findByMnoBetweenOrderByMnoDesc(70L, 80L);
        for (Memo memo : list) {
            log.info(memo);
        }
    }

    @Test
    void testQueryMethodWithPageable() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").descending());
        Page<Memo> result = memoRepository.findByMnoBetween(10L, 50L, pageable);
        result.get().forEach(log::info);
    }

    @Commit
    @Transactional
    @Test
    void testDeleteQueryMethods() {
        memoRepository.deleteMemoByMnoLessThan(20L);
    }

    @Test
    void testQueryAnnotation() {
        List<Memo> listDesc = memoRepository.getListDesc();
        listDesc.forEach(log::info);
    }

    @Test
    void testQuery() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());
        QBoard qBoard = QBoard.board;
        String keyword = "1";
        BooleanBuilder builder = new BooleanBuilder();
        BooleanExpression expression = qBoard.title.contains(keyword);
        builder.and(expression);
        Page<Board> result = boardRepository.findAll(builder, pageable);

        result.stream().forEach(log::info);
    }

    @Test
    void testQuery2() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());
        QBoard qBoard = QBoard.board;
//        String keyword = "1";
        BooleanBuilder builder = new BooleanBuilder();
        BooleanExpression exTitle = qBoard.title.contains("1");
        BooleanExpression exContent = qBoard.content.contains("3");
        builder.and(qBoard.bno.gt(200L)).and(exTitle).or(exContent);
        Page<Board> result = boardRepository.findAll(builder, pageable);

        result.stream().forEach(log::info);
    }
}