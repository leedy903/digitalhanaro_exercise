package org.conan.mapper;

import org.apache.ibatis.annotations.Select;
import org.conan.domain.Board;

import java.util.List;

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
