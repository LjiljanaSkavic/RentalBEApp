package rentalapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rentalapp.entity.ClientEntity;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {
}
