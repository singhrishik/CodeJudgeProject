package org.codejudge.sb.dao;

import org.codejudge.sb.model.Quiz;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public interface QuizDao {

    Quiz insertQuiz(int id, Quiz quiz);

    default Quiz insertQuiz(Quiz quiz) {
        int id = new Random().nextInt();
        if(id<0) id*=(-1);
        return insertQuiz(id, quiz);
    }

    List<Quiz> selectAllQuiz();

    List<Quiz> selectQuizByID(int id);

}
