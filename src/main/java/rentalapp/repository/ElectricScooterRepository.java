package rentalapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rentalapp.entity.ElectricScooterEntity;

@Repository
public interface ElectricScooterRepository extends JpaRepository<ElectricScooterEntity, Integer> {
    Page<ElectricScooterEntity> findAllByIsDeletedFalse(Pageable pageable);
}