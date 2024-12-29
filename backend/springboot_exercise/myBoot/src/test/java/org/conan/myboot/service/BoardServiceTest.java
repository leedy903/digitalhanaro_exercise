package org.conan.myboot.service;

import lombok.extern.log4j.Log4j2;
import org.conan.myboot.domain.PageRequestDTO;
import org.conan.myboot.domain.PageResultDTO;
import org.conan.myboot.dto.BoardDTO;
import org.conan.myboot.domain.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
class BoardServiceTest {
    @Autowired
    BoardService boardService;

    @Test
    void write() {
        BoardDTO boardDTO = BoardDTO.builder().title("Test Title 1").content("Test Content").writer("user001").build();
        log.info(boardService.write(boardDTO));
    }

    @Test
    void testList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(5).build();
        PageResultDTO<BoardDTO, Board> resultDTO = boardService.getList(pageRequestDTO);

        log.info("PREV: " + resultDTO.isPrev());
        log.info("NEXT: " + resultDTO.isNext());
        log.info("TOTAL PAGE: " + resultDTO.getTotalPage());
        log.info("========================================");

        for (BoardDTO boardDTO : resultDTO.getDtoList()) {
            log.info(boardDTO);
        }

        log.info("========================================");
        resultDTO.getPageList().forEach(log::info);
    }
}