package net.ojm.bky.repository;

import net.ojm.bky.entity.QuizDefinitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuizDefinitionRepository extends JpaRepository<QuizDefinitionEntity, Long> {
    Optional<QuizDefinitionEntity> findByTitle(String title);
}
