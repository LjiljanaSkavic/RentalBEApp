package rentalapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rentalapp.entity.CarEntity;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Integer>, VehicleCommonRepository {
}