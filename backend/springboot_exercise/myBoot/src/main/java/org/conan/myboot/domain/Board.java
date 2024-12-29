package org.conan.myboot.domain;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "board")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "writer")
@Getter
public class Board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    @Column(length = 40, nullable = false)
    private String title;

    @Column(length = 100, nullable = false)
    private String content;

//    @Column(length = 40, nullable = false)
//    private String writer;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member writer; // 연관관계 지정

    @Builder.Default
    private Integer hit = 0;
}

//import lombok.Data;
//
//import java.time.LocalDateTime;
//
//@Data
//public class Board {
//    private Integer bno;
//    private String title;
//    private String content;
//    private String writer;
//    private LocalDateTime regDate;
//    private Integer hit;
//}
