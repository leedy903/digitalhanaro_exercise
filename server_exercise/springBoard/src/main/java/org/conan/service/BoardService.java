package org.conan.service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.conan.domain.Board;
import org.conan.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Log4j
@Service
public class BoardService {
    @Setter(onMethod_ = @Autowired)
    private BoardMapper boardMapper;

    public List<Board> getList() {
        System.out.println("BoardService.getList");
        return boardMapper.getList();
    }

    public void write(Board board) {
        System.out.println("BoardService.write");
        boardMapper.insertSelectKey(board);
    }

    public Board read(Integer bno) {
        System.out.println("BoardService.get"+bno);
        return boardMapper.read(bno);
    }

    public boolean modify(Board board) {
        System.out.println("BoardService.modify" + board);
        return boardMapper.update(board) == 1;
    }

    public boolean remove(Integer bno) {
        System.out.println("BoardService.remove" + bno);
        return boardMapper.delete(bno) == 1;
    }

}
