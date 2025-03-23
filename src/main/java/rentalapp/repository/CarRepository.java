package rentalapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rentalapp.entity.CarEntity;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Integer> {
    Page<CarEntity> findAllByIsDeletedFalse(Pageable pageable);
}