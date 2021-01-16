package org.codejudge.sb.service;

import org.codejudge.sb.dao.QuestionDao;
import org.codejudge.sb.dao.QuizDao;
import org.codejudge.sb.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    private final QuizDao quizDao;


    @Autowired
    public QuizService(@Qualifier("fakeQuiz") QuizDao quizDao) {
        this.quizDao = quizDao;
    }


    public Quiz addQuiz(Quiz quiz){
       return quizDao.insertQuiz(quiz);
    }

    public List<Quiz> getAllQuiz(){
        return quizDao.selectAllQuiz();
    }

    public List<Quiz> getQuizByID(int id){
        return quizDao.selectQuizByID(id);
    }


}
