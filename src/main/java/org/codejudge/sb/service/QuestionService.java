package org.codejudge.sb.service;

import org.codejudge.sb.dao.QuestionDao;
import org.codejudge.sb.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionDao questionDao;

    @Autowired
    public QuestionService(@Qualifier("fakeQuestion") QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public Question addQuestion(Question question) {
        return questionDao.insertQuestion(question);
    }

    public Question getQuestionByID(int id) {
        return questionDao.selectQuestionByID(id);
    }
}
