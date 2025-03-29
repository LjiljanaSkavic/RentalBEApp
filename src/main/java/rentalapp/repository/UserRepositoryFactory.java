package rentalapp.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import rentalapp.entity.UserEntity;
import rentalapp.enums.UserType;

@Component
@RequiredArgsConstructor
public class UserRepositoryFactory {
    private final ClientRepository clientRepository;
    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;

    public JpaRepository<? extends UserEntity, Integer> get(UserType type) {
        if (type == null) {
            return userRepository;
        }
        return switch (type) {
            case CLIENT -> clientRepository;
            case EMPLOYEE -> employeeRepository;
            default -> userRepository;
        };
    }
}
