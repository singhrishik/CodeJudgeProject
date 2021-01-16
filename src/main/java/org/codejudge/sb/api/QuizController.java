package org.codejudge.sb.api;

import org.codejudge.sb.model.ExceptionMessage;
import org.codejudge.sb.model.Quiz;
import org.codejudge.sb.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RequestMapping("api/quiz")
@RestController
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz) {
        return new ResponseEntity<>(quizService.addQuiz(quiz), HttpStatus.CREATED);
    }

//    @GetMapping
//    public List<Quiz> getAllQuiz() {
//        return quizService.getAllQuiz();
//    }

    @GetMapping("{id}")
    public ResponseEntity<List<Quiz>> getQuizByID(@PathVariable("id") int id) {
        List<Quiz> quizList = quizService.getQuizByID(id);
        if(quizList.size()==0)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        else
        return new ResponseEntity<>(quizService.getQuizByID(id), HttpStatus.OK);
    }


    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<ExceptionMessage> getException(){
        ExceptionMessage exceptionMessage = new ExceptionMessage("failure","This is a bad Request");
        return new ResponseEntity<>(exceptionMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<String> getNotFoundException(){
        return new ResponseEntity<String>("{}", HttpStatus.NOT_FOUND);
    }

}
