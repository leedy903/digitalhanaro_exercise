package org.conan.utils;

import lombok.Setter;
import org.conan.domain.Board;
import org.conan.mapper.BoardMapper;
import org.conan.mapper.TimeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//@Log4j
public class BoardMapperTest {
    @Setter(onMethod_ = {@Autowired})
    private BoardMapper boardMapper;

    @Test
    public void testGetList() {
        boardMapper.getList().forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        Board board = new Board();
        board.setTitle("새로 작성하는 글");
        board.setContent("새로 작성하는 내용");
        board.setWriter("newbie");
        boardMapper.insert(board);
        System.out.println(board);
    }

    @Test
    public void testInsertSelectKey() {
        Board board = new Board();
        board.setTitle("새로 작성하는 글");
        board.setContent("새로 작성하는 내용");
        board.setWriter("newbie");
        boardMapper.insertSelectKey(board);
        System.out.println(board);
    }

    @Test
    public void testRead() {
        Board board = boardMapper.read(5);
        System.out.println("board = " + board);
    }

    @Test
    public void testIncreaseHit() {
        int i = boardMapper.increaseHit(5);
        System.out.println("i = " + i);
    }

    @Test
    public void testDelete() {
        System.out.println("delete count = " + boardMapper.delete(5));
    }

    @Test
    public void testUpdate() {
        Board board = new Board();
        board.setBno(2);
        board.setTitle("수정한 제목");
        board.setContent("수정한 내용");
        int count = boardMapper.update(board);
        System.out.println("update count = " + count);
    }
}