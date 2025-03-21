package rentalapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import rentalapp.entity.ManufacturerEntity;

public interface ManufacturerRepository extends JpaRepository<ManufacturerEntity, Integer> {
    Page<ManufacturerEntity> findAllByIsDeletedFalse(Pageable page);
}