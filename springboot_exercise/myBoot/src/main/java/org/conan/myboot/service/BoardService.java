package org.conan.myboot.service;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.conan.myboot.dao.BoardMapper;
import org.conan.myboot.domain.PageRequestDTO;
import org.conan.myboot.domain.PageResultDTO;
import org.conan.myboot.dto.BoardDTO;
import org.conan.myboot.domain.Board;
import org.conan.myboot.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Log4j2
@Service
@RequiredArgsConstructor
public class BoardService {

    @Setter(onMethod_ = @Autowired)
    private BoardMapper boardMapper;


//    public List<Board> getList() {
//        System.out.println("BoardService.getList");
//        return boardMapper.getList();
//    }

    public void write(Board board) {
        System.out.println("BoardService.write");
        boardMapper.insertSelectKey(board);
    }

    public Board read(Integer bno) {
        System.out.println("BoardService.get" + bno);
        boardMapper.increaseHit(bno);
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

    private final BoardRepository boardRepository;

    public Long write(BoardDTO dto) {
        log.info("DTO ==========");
        log.info(dto);
        Board entity = dtoToEntity(dto);
        log.info(entity);
        boardRepository.save(entity);
        return entity.getBno();
    }

    public Board dtoToEntity(BoardDTO dto) {
        return Board.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
//                .writer(dto.getWriter())
                .hit(dto.getHit())
                .build();
    }

    public PageResultDTO<BoardDTO, Board> getList(PageRequestDTO requestDTO) {
        log.info("requestDto", requestDTO);
        Pageable pageable = requestDTO.getPageable(Sort.by("bno").descending());
        Page<Board> result = boardRepository.findAll(pageable);
        Function<Board, BoardDTO> fn = (this::entityToDto);
        return new PageResultDTO<>(result, fn);
    }

    private BoardDTO entityToDto(Board entity) {
        return BoardDTO.builder()
                .bno(entity.getBno())
                .title(entity.getTitle())
                .content(entity.getContent())
//                .writer(entity.getWriter())
                .hit(entity.getHit())
                .build();

    }


}
