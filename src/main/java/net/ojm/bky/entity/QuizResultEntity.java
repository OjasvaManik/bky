package net.ojm.bky.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "quiz_results")
@Getter @Setter @ToString @NoArgsConstructor
public class QuizResultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "quiz_def_id")
    private QuizDefinitionEntity quizDefinition;

    @Column(name = "result_summary")
    private String resultSummary; // Could be "INTJ", "High Openness", etc.

    @Column(name = "submitted_at")
    private LocalDateTime submittedAt = LocalDateTime.now();
}

