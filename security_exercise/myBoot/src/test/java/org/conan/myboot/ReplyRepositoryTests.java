package org.conan.myboot;

import lombok.extern.log4j.Log4j2;
import org.conan.myboot.domain.Board;
import org.conan.myboot.domain.Member;
import org.conan.myboot.domain.Reply;
import org.conan.myboot.repository.ReplyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class ReplyRepositoryTests {
    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void insertReply() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            long bno = (long) (Math.random()*100) + 1;
            Board board = Board.builder().bno(bno).build();
            Reply reply = Reply.builder()
                    .reply("Reply..." + i)
                    .board(board)
                    .replyer("guest")
                    .build();
            replyRepository.save(reply);
        });
    }

    @Test
    public void readReply1() {
        Optional<Reply> result = replyRepository.findById(2L);
        Reply reply = result.get();
        log.info(reply);
        log.info(reply.getBoard());
    }
}
