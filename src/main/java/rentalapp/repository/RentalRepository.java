package rentalapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rentalapp.entity.RentalEntity;

@Repository
public interface RentalRepository extends JpaRepository<RentalEntity, Integer> {
    Page<RentalEntity> findAll(Pageable page);
}
