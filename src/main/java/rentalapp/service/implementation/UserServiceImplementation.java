package rentalapp.service.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import rentalapp.dto.EmployeeDTO;
import rentalapp.dto.PasswordRequest;
import rentalapp.dto.SearchResult;
import rentalapp.dto.UserDTO;
import rentalapp.entity.EmployeeEntity;
import rentalapp.entity.UserEntity;
import rentalapp.enums.UserType;
import rentalapp.repository.EmployeeRepository;
import rentalapp.repository.FileRepository;
import rentalapp.repository.UserRepository;
import rentalapp.repository.UserRepositoryFactory;
import rentalapp.service.UserService;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private final ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private UserRepositoryFactory userRepositoryFactory;
    @Autowired
    private EmployeeRepository employeeRepository;

    public UserServiceImplementation(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public SearchResult<? extends UserDTO> getAllPageable(int page, int size, UserType type) {
        Pageable pageable = PageRequest.of(page, size);
        Page<? extends UserEntity> userEntities = userRepositoryFactory.get(type).findAll(pageable);

        List<? extends UserDTO> userDTOs = userEntities.stream()
                .map(obj -> modelMapper.map(obj, type.getDtoClass()))
                .toList();

        return new SearchResult<>(
                userDTOs,
                userEntities.getTotalElements(),
                userEntities.getTotalPages(),
                userEntities.getNumber(),
                userEntities.getSize()
        );
    }

    @Override
    public EmployeeDTO loginEmployee(String username, String password) {
        try {
            EmployeeEntity employeeEntity = employeeRepository.findByUsernameAndPassword(username, password);
            if (employeeEntity != null) {
                return modelMapper.map(employeeEntity, EmployeeDTO.class);
            }
        } catch (Exception e) {

            System.err.println("Error during employee login: " + e.getMessage());
        }
        return null;
    }

    @Override
    public EmployeeDTO changePassword(Integer id, PasswordRequest passwordRequest) {
        EmployeeEntity employeeEntity = employeeRepository.findByIdAndPassword(id, passwordRequest.getCurrentPassword());
        if (employeeEntity != null) {
            employeeEntity.setPassword(passwordRequest.getNewPassword());
            employeeRepository.save(employeeEntity);
            return modelMapper.map(employeeEntity, EmployeeDTO.class);

        }
        return null;
    }
}
