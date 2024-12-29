package org.conan.myboot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.conan.myboot.domain.Board;

import java.util.List;

@Mapper
public interface BoardMapper {
    public List<Board> getList();
    public int insert(Board board);
    public int insertSelectKey(Board board);
    public Board read(Integer bno);
    public void increaseHit(Integer bno);
    public int delete(Integer bno);
    public int update(Board board);
}
