package org.conan.myboot.domain;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "tbl_todo")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tno;

    @Column(length = 200, nullable = false)
    private String title;

    @Column(nullable = false)
    private String writer;

    @Column
    private Boolean complete;

    @Column
    private LocalDate dueDate;
}
