package mts.homework.sivelkaev.model.repository;

import mts.homework.sivelkaev.model.entity.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true, noRollbackFor = Exception.class)
public interface AnimalRepository extends JpaRepository<AnimalEntity, Long> {
}
