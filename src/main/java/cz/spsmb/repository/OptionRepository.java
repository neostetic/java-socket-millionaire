package cz.spsmb.repository;

import cz.spsmb.entity.OptionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends CrudRepository<OptionEntity, Long> {
}
