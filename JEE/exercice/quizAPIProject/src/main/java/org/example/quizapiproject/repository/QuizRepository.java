package org.example.quizapiproject.repository;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.quizapiproject.model.Quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@ApplicationScoped
public class QuizRepository {
    private final Map<Long, Quiz> quizzes = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(0);

    public  Quiz saveNewQuiz(Quiz quiz) {
        if(quiz.getId() == null) {
            quiz.setId(idGenerator.incrementAndGet());
        }
        quizzes.put(quiz.getId(),quiz);
        return quiz;
    }

    public  Quiz findQuizById(long id) {
        return quizzes.get(id);
    }

    public List<Quiz> findAllQuiz() {
        return new ArrayList<>(quizzes.values());
    }

    public void deleteQuizById(long id) {
        quizzes.remove(id);
    }
}
