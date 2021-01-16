package org.codejudge.sb.dao;

import org.codejudge.sb.model.Quiz;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("fakeQuiz")
public class FakeQuizDataAccessService implements QuizDao {

    private static List<Quiz> DB = new ArrayList<>();

    @Override
    public Quiz insertQuiz(int id, Quiz quiz) {
        DB.add(new Quiz(id, quiz.getName(), quiz.getDescription()));
        return new Quiz(id, quiz.getName(), quiz.getDescription());
    }

    @Override
    public List<Quiz> selectAllQuiz() {
        return DB;
    }

    @Override
    public List<Quiz> selectQuizByID(int id) {
        List<Quiz> list = new ArrayList<>();
        for (int i = 0; i < DB.size(); i++) {
            if(DB.get(i).getId()==id){
                list.add(DB.get(i));
            }
        }
        return list;
    }



}
