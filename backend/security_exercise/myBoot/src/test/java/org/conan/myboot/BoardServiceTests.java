package org.conan.myboot;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.extern.log4j.Log4j2;
import org.conan.myboot.domain.*;
import org.conan.myboot.repository.BoardRepository;
import org.conan.myboot.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;



@SpringBootTest
@Log4j2
public class BoardServiceTests {
    @Autowired
    BoardService boardService;
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testQuery() {
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
    public void testQuery2() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());
        QBoard qBoard = QBoard.board;
        BooleanBuilder builder = new BooleanBuilder();
        BooleanExpression exTitle = qBoard.title.contains("1");
        BooleanExpression exContent = qBoard.content.contains("3");
        builder.and(qBoard.bno.gt(200L)).and(exTitle).or(exContent);
        Page<Board> result = boardRepository.findAll(builder, pageable);
        result.stream().forEach(log::info);
    }

    @Test
    public void testList() {
        PageRequestDTO pageRequestDTO =
                PageRequestDTO.builder().page(1).size(5).build();
        PageResultDTO<BoardDTO, Object[]> resultDTO = boardService.getList(pageRequestDTO);
        log.info("==============================");

        log.info("PREV : " + resultDTO.isPrev());
        log.info("NEXT : " + resultDTO.isNext());
        log.info("TOTAL PAGE : " + resultDTO.getTotalPage());
        for (BoardDTO boardDTO : resultDTO.getDtoList()) {
            log.info(boardDTO);
        }

        log.info("------------------------------------");
        resultDTO.getPageList().forEach(i -> log.info(i));
    }

    @Test
    public void write() {
        BoardDTO boardDTO = BoardDTO.builder()
                .title("Test Title1")
                .content("Test Content1")
                .writerEmail("user5@aaa.com")
                .build();
        log.info(boardService.write(boardDTO));
    }

}
