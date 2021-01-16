package org.codejudge.sb.dao;

import org.codejudge.sb.model.Question;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("fakeQuestion")
public class FakeQuestionDataAccessService implements QuestionDao{


    private static List<Question> DB = new ArrayList<>();

    @Override
    public Question insertQuestion(int id, Question question) {
       DB.add(new Question(id,question.getName(),
               question.getOptions(),
               question.getCorrectOption(),
               question.getQuizId(),
               question.getPoints()));

       return new Question(id,question.getName(),
               question.getOptions(),
               question.getCorrectOption(),
               question.getQuizId(),
               question.getPoints());

    }


    @Override
    public Question selectQuestionByID(int id) {
        Question question = new Question();
        for (int i = 0; i < DB.size(); i++) {
            if(DB.get(i).getId()==id){
                question=(DB.get(i));
                break;
            }
        }
        return question;
    }

}
