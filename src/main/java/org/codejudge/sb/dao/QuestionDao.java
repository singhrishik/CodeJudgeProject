package org.codejudge.sb.dao;

import org.codejudge.sb.model.Question;
import org.codejudge.sb.model.Quiz;

import java.util.List;
import java.util.Random;

public interface QuestionDao {

    Question insertQuestion(int id, Question question);

    default Question insertQuestion(Question question){
        int id = new Random().nextInt();
        if(id<0) id*=(-1);
        return insertQuestion(id,question);
    }

    Question selectQuestionByID(int id);



}
