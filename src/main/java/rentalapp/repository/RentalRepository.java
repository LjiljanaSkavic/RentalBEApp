package rentalapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rentalapp.entity.RentalEntity;

import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<RentalEntity, Integer> {
    Page<RentalEntity> findAll(Pageable page);

    @Query("SELECT r FROM RentalEntity r WHERE r.vehicle.id = :id")
    List<RentalEntity> findAllByVehicleId(Integer id);
}
