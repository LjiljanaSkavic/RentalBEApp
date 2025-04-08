package rentalapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rentalapp.entity.MalfunctionEntity;

import java.util.List;

@Repository
public interface MalfunctionRepository extends JpaRepository<MalfunctionEntity, Integer> {
    @Query("SELECT m FROM MalfunctionEntity m WHERE m.vehicleId = :id")
    List<MalfunctionEntity> findAllByVehicleId(Integer id);
}
