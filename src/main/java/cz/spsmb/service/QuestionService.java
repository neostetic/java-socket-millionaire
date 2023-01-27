package cz.spsmb.service;

import cz.spsmb.entity.Question;

import java.util.List;

public interface QuestionService {

    List<Question> getAll();

    void save(Question question);

    Question getQuestionByUuid(String uuid);
}
