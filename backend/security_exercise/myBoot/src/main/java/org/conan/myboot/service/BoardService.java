package org.conan.myboot.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.conan.myboot.domain.*;
import org.conan.myboot.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;


@Service
@Log4j2
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    public Long write(BoardDTO dto) {
        log.info("DTO---------");
        log.info(dto);
        Board entity = dtoToEntity(dto);
        log.info(entity);
        boardRepository.save(entity);
        return entity.getBno();
    }
    public Board dtoToEntity(BoardDTO dto) {
        Member member = Member.builder().email(dto.getWriterEmail()).build();
        return Board.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(member)
                .build();
    }

//    public PageResultDTO<BoardDTO, Board> getList(PageRequestDTO requestDTO) {
//        Pageable pageable = requestDTO.getPageable(Sort.by("bno").descending());
//        Page<Board> result = boardRepository.findAll(pageable);
//        Function<Board, BoardDTO> fn = (entity -> entityToDto(entity));
//        return new PageResultDTO<>(result, fn);
//    }

    public BoardDTO entityToDto(Board board, Member member, Long replyCount) {
        return BoardDTO.builder()
                .bno(board.getBno())
                .title(board.getTitle())
                .content(board.getContent())
                .writerEmail(member.getEmail())
                .writerName(member.getName())
                .regDate(board.getRegDate())
                .modDate(board.getModDate())
                .replyCount(replyCount.intValue())
                .build();
    }

    public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO requestDTO) {
        log.info(requestDTO);
        Function<Object[], BoardDTO> fn = (en -> entityToDto((Board) en[0], (Member) en[1], (Long) en[2]));
        Page<Object[]> result = boardRepository.getBoardWithReplyCount(requestDTO.getPageable(Sort.by("bno").descending()));
        return new PageResultDTO<>(result, fn);
    }
}