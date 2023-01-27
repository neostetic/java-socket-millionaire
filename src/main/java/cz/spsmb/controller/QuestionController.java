package cz.spsmb.controller;

import cz.spsmb.entity.Question;
import cz.spsmb.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {

    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(path = "/questions", method = RequestMethod.GET)
    public List<Question> getAllQuestions() {
        return questionService.getAll();
    }

    @RequestMapping(path = "/question", method = RequestMethod.POST)
    public void saveQuestion(@RequestBody Question question) {
        questionService.save(question);
    }

    @RequestMapping(path = "/question/{id}", method = RequestMethod.GET)
    public Question getQuestionByUuid(@PathVariable String id) {
        return this.questionService.getQuestionByUuid(id);
    }

}
