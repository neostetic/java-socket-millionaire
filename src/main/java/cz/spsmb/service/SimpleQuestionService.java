package cz.spsmb.service;

import cz.spsmb.entity.Question;
import cz.spsmb.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class SimpleQuestionService implements QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public SimpleQuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> getAll() {
        List<Question> questions = new LinkedList<>();
        for (Question question: this.questionRepository.findAll()) {
            questions.add(question);
        }

        UUID uuid = UUID.randomUUID();
        uuid.toString();
        return questions;
    }

    @Override
    public void save(Question question) {
        this.questionRepository.save(question);
    }

    @Override
    public Question getQuestionByUuid(String uuid) {
        return this.questionRepository.findByUuid(uuid);
    }

}
