package cz.spsmb.controller;

import cz.spsmb.dto.in.QuestionDto;
import cz.spsmb.entity.OptionEntity;
import cz.spsmb.entity.Question;
import cz.spsmb.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@RestController
public class QuestionController {

    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(path = "/questions", method = RequestMethod.GET)
    public List<QuestionDto> getAllQuestions() {
        return convertToDto(questionService.getAll());
    }

    private List<QuestionDto> convertToDto(List<Question> all) {
        List<QuestionDto> questionDtos = new LinkedList<>();
        for(Question question : all) {
            QuestionDto questionDto = new QuestionDto();
            questionDto.setQuestion(question.getQuestion());
            questionDto.setOptions(new HashSet<>());
            questionDto.setAnswer(question.getRightOption().getValue());
            for(OptionEntity optionEntity : question.getOptions()) {
                questionDto.getOptions().add(optionEntity.getValue());
            }
            questionDtos.add(questionDto);
        }
        return questionDtos;
    }

    @RequestMapping(path = "/question", method = RequestMethod.POST)
    public void saveQuestion(@RequestBody QuestionDto question) {
        questionService.save(question);
    }

    @RequestMapping(path = "/question/{id}", method = RequestMethod.GET)
    public Question getQuestionByUuid(@PathVariable String id) {
        return this.questionService.getQuestionByUuid(id);
    }

    @RequestMapping(path = "/question/random", method = RequestMethod.GET)
    public QuestionDto getRandomQuestion() {
        List<QuestionDto> list = convertToDto(questionService.getAll());
        return list.get(getRandomNumber(0, list.size()));
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}
