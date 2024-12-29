package org.conan.myboot.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
//@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDTO {
    private Long bno;
    private String title, content, writerEmail, writerName;
    private LocalDateTime regDate, modDate;
    private Integer replyCount;
}