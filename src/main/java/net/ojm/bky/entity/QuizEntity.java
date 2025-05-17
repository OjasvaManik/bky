package net.ojm.bky.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "quiz")
public class QuizEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "quiz_id")
    private Long id;

    @Column(name = "quiz_name", nullable = false)
    private String quizName;

    @Column(name = "score", nullable = false)
    private int score;

    @Column(name = "date_taken")
    private LocalDateTime dateTaken = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
}
