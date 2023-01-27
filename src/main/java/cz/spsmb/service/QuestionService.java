package cz.spsmb.service;

import cz.spsmb.dto.in.QuestionDto;
import cz.spsmb.entity.Question;

import java.util.List;

public interface QuestionService {

    List<Question> getAll();

    void save(QuestionDto question);

    Question getQuestionByUuid(String uuid);
}
