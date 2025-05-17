package net.ojm.bky;

import net.ojm.bky.entity.QuizDefinitionEntity;
import net.ojm.bky.repository.QuizDefinitionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BkyApplication {

    public static void main(String[] args) {
        SpringApplication.run(BkyApplication.class, args);
    }

    @Bean
    CommandLineRunner preloadQuizzes(QuizDefinitionRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(new QuizDefinitionEntity("Myers-Briggs Type Indicator", "MBTI"));
                repo.save(new QuizDefinitionEntity("OCEAN personality model", "Big Five"));
                repo.save(new QuizDefinitionEntity("9 core types", "Enneagram"));
                repo.save(new QuizDefinitionEntity("Ancient temperamental theory", "Four Temperaments"));
                repo.save(new QuizDefinitionEntity("Dominance, Influence, Steadiness, Conscientiousness", "DISC"));
                repo.save(new QuizDefinitionEntity("Software Developer, AI Engineer, etc.", "Career - Technology & IT"));
                repo.save(new QuizDefinitionEntity("Doctor, Pharmacist, etc.", "Career - Healthcare & Medicine"));
                repo.save(new QuizDefinitionEntity("Mechanical, Civil, etc.", "Career - Engineering"));
                repo.save(new QuizDefinitionEntity("Marketing, HR, etc.", "Career - Business & Management"));
                repo.save(new QuizDefinitionEntity("Designer, Writer, etc.", "Career - Creative & Media"));
                repo.save(new QuizDefinitionEntity("Teacher, Researcher, etc.", "Career - Education & Research"));
            }
        };
    }
}