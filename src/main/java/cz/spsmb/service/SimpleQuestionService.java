package cz.spsmb.service;

import cz.spsmb.dto.in.QuestionDto;
import cz.spsmb.entity.OptionEntity;
import cz.spsmb.entity.Question;
import cz.spsmb.repository.OptionRepository;
import cz.spsmb.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class SimpleQuestionService implements QuestionService {

    private final QuestionRepository questionRepository;
    private final OptionRepository optionRepository;

    @Autowired
    public SimpleQuestionService(QuestionRepository questionRepository, OptionRepository optionRepository) {
        this.questionRepository = questionRepository;
        this.optionRepository = optionRepository;
    }

    @Override
    public List<Question> getAll() {
        List<Question> questions = new LinkedList<>();
        for (Question question: this.questionRepository.findAll()) {
            questions.add(question);
        }
        return questions;
    }

    @Override
    public void save(QuestionDto questionDto) {
        Question question = Question.builder()
                .uuid(UUID.randomUUID().toString())
                .question(questionDto.getQuestion())
                .options(new LinkedList<>())
                // TODO difficulty
                .build();

        for (String option : questionDto.getOptions()) {
            OptionEntity optionEntity = new OptionEntity();
            optionEntity.setValue(option);
            optionEntity.setQuestion(question);
            if(questionDto.getAnswer().compareTo(option) == 0) {
                question.setRightOption(optionEntity);
            }

            question.getOptions().add(optionEntity);
        }
        // optionRepository.save(optionEntity);


        System.out.println(question.getQuestion() + " : " + question.getUuid());
        this.questionRepository.save(question);
    }

    @Override
    public Question getQuestionByUuid(String uuid) {
        return this.questionRepository.findByUuid(uuid);
    }

}
