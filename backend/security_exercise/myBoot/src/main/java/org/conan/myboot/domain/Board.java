package org.conan.myboot.domain;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString (exclude = "writer")
@Getter
@Table(name="board")
public class Board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;
    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member writer;

    @Builder.Default
    private Integer hit =0;
}