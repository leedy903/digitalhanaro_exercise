package org.conan.myboot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.conan.myboot.domain.Board;

import java.util.List;

@Mapper
public interface BoardMapper {
//    @Select("SELECT * FROM BOARD WHERE BNO > 0")
    List<Board> getList();

    int insert(Board board);

    int insertSelectKey(Board board);

    Board read(Integer bno);

    int increaseHit(Integer bno);

    int delete(Integer bno);

    int update(Board board);
}
