package net.ojm.bky.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "quiz_definitions")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class QuizDefinitionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, nullable = false)
    private String title; // e.g. "MBTI", "Big Five", etc.

    private String description;

    public QuizDefinitionEntity(String title, String description) {
        this.title = title;
        this.description = description;
    }
}