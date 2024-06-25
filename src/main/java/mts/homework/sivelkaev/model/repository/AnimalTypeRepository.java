package mts.homework.sivelkaev.model.repository;

import mts.homework.sivelkaev.model.entity.AnimalTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true, noRollbackFor = Exception.class)
public interface AnimalTypeRepository extends JpaRepository<AnimalTypeEntity, Long> {
    Optional<AnimalTypeEntity> findByType(String type);
}
