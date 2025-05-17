package net.ojm.bky.controller;

import lombok.RequiredArgsConstructor;
import net.ojm.bky.dto.QuizResultDTO;
import net.ojm.bky.entity.QuizEntity;
import net.ojm.bky.entity.QuizResultEntity;
import net.ojm.bky.entity.UserEntity;
import net.ojm.bky.repository.QuizDefinitionRepository;
import net.ojm.bky.repository.QuizRepository;
import net.ojm.bky.repository.QuizResultRepository;
import net.ojm.bky.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
@RequiredArgsConstructor
public class QuizController {

    private final QuizRepository quizRepository;
    private final UserRepository userRepository;
    private final QuizDefinitionRepository quizDefinitionRepository;
    private final QuizResultRepository quizResultRepository;

    @PostMapping("/submit")
    public ResponseEntity<?> submitQuizResult(@RequestBody QuizResultDTO dto) {
        var user = userRepository.findById(dto.userId()).orElse(null);
        var quizDef = quizDefinitionRepository.findByTitle(dto.quizTitle()).orElse(null);

        if (user == null || quizDef == null) {
            return ResponseEntity.badRequest().body("Invalid user or quiz name.");
        }

        QuizResultEntity result = new QuizResultEntity();
        result.setUser(user);
        result.setQuizDefinition(quizDef);
        result.setResultSummary(dto.resultSummary());

        quizResultRepository.save(result);

        return ResponseEntity.ok("Quiz result saved.");
    }


    @GetMapping("/results/{userId}")
    public ResponseEntity<List<QuizEntity>> getResults(@PathVariable Long userId) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        if (user == null) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(quizRepository.findByUser(user));
    }
}
