package cz.spsmb.repository;

import cz.spsmb.entity.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
    Question findByUuid(String uuid);
}
