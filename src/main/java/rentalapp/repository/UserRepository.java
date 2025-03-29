package rentalapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rentalapp.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
//    UserEntity findByUsernameAndPassword(String username, String password);
//
//    UserEntity findByIdAndPassword(Integer id, String password);
}
