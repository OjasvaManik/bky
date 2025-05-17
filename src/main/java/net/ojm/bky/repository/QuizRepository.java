package net.ojm.bky.repository;

import net.ojm.bky.entity.QuizEntity;
import net.ojm.bky.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<QuizEntity, Long> {
    List<QuizEntity> findByUser(UserEntity user);
}
