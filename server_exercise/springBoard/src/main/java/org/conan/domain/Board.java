package org.conan.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Board {
    private Integer bno;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    private Integer hit;
}
