package org.conan.myboot;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.conan.myboot.domain.Memo;
import org.conan.myboot.repository.MemoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class MemoRepositoryTests {
    @Autowired
    MemoRepository memoRepository;

    @Test
    public void testClass() {
        log.info(memoRepository.getClass().getName());
    }

    @Test
    public void testInsertDummies() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Memo memo = Memo.builder().memoText("Sample ..." + i).build();
            memoRepository.save(memo);
        });
    }

    @Test
    public void testSelect() {
        Long mno = 10L;
        Optional<Memo> result = memoRepository.findById(mno);
        log.info("==========================");
        if (result.isPresent()) {
            Memo memo = result.get();
            log.info(memo);
        }
    }

    @Transactional
    @Test
    public void testSelect2() {
        Long mno = 5L;
        Memo memo = memoRepository.getOne(mno);
        log.info("================================");
        log.info(memo);
    }

    @Test
    public void testUpdate() {
        Memo memo = Memo.builder().mno(5L).memoText("Update Text").build();
        log.info(memoRepository.save(memo));
    }

    @Test
    public void testDelete() {
        Long mno = 5L;
        memoRepository.deleteById(mno);
    }

    @Test
    public void testPageDefault() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<Memo> result = memoRepository.findAll(pageable);
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
    public void testSort() {
        Sort sort1 = Sort.by("mno").descending();
        Pageable pageable = PageRequest.of(0, 10, sort1);
        Page<Memo> result = memoRepository.findAll(pageable);
        result.get().forEach(memo -> {
            log.info(memo);
        });
    }
}
