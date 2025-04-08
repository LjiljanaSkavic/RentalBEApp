package rentalapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rentalapp.entity.MalfunctionEntity;

@Repository
public interface MalfunctionRepository extends JpaRepository<MalfunctionEntity, Integer> {
}
