package org.example.quizapiproject.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.quizapiproject.model.Quiz;
import org.example.quizapiproject.repository.QuizRepository;

import java.util.List;

@ApplicationScoped
public class QuizService {

    private QuizRepository quizRepository;

    @Inject
    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public  Quiz addQuiz(Quiz quiz) {
        return quizRepository.saveNewQuiz(quiz);
    }

    public List<Quiz> getAllQuiz() {
        return quizRepository.findAllQuiz();
    }

    public Quiz getQuizById(Long id) {
        return  quizRepository.findQuizById(id);

    }

    public void deleteQuizById(Long id) {
        quizRepository.deleteQuizById(id);

    }
}
