package org.conan.utils;

import lombok.Setter;
import org.conan.domain.Board;
import org.conan.mapper.BoardMapper;
import org.conan.service.BoardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//@Log4j
public class BoardServiceTest {
    @Setter(onMethod_ = {@Autowired})
    private BoardService boardService;

    @Test
    public void testExist() {
        System.out.println("boardService = " + boardService);
        assertNotNull(boardService);
    }

    @Test
    public void testGetList() {
        boardService.getList().forEach(System.out::println);
    }

    @Test
    public void testWrite() {
        Board board = new Board();
        board.setTitle("새글 Service");
        board.setContent("새 내용 새 내용 from Service");
        board.setWriter("newbie");
        boardService.write(board);
        System.out.println("board.getBno() = " + board.getBno());
    }

    @Test
    public void testRead() {
        System.out.println("boardService.read(9).getTitle() = " + boardService.read(9).getTitle());
    }

    @Test
    public void testDelete() {
        System.out.println("boardService.remove(9) = " + boardService.remove(9));
    }

    @Test
    public void testUpdate() {
        Board board = boardService.read(7);
        if(board==null){
            return;
        }
        board.setTitle("수정 Service");
        System.out.println("boardService.modify(board) = " + boardService.modify(board));
    }
}