package rentalapp.service.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import rentalapp.dto.SearchResult;
import rentalapp.dto.UserDTO;
import rentalapp.entity.UserEntity;
import rentalapp.enums.UserType;
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

//    @Override
//    public Employee loginEmployee(String username, String password) {
//        try {
//            UserEntity user = userRepository.findByUsernameAndPassword(username, password);
//            if (user != null) {
//                return getEmployeeDTO(user);
//            }
//        } catch (Exception e) {
//
//            System.err.println("Error during employee login: " + e.getMessage());
//        }
//        return null;
//    }

//    @Override
//    public Employee changePassword(Integer id, PasswordRequest passwordRequest) {
//        UserEntity user = userRepository.findByIdAndPassword(id, passwordRequest.getCurrentPassword());
//        if (user != null) {
//            user.setPassword(passwordRequest.getNewPassword());
//            userRepository.save(user);
//        }
//        return user != null ? getEmployeeDTO(user) : null;
//    }


//    private Employee getEmployeeDTO(UserEntity user) {
//        EmployeeEntity employeeEntity = employeeRepository.findByUserId(user.getId());
//        FileEntity userProfilePictureFile = fileRepository.findById(user.getProfilePictureId()).orElse(null);
//        String role = employeeEntity.getRole();
//        Employee employee = modelMapper.map(user, Employee.class);
//        RentalFile rentalFile = convertFileDTO(userProfilePictureFile);
//        employee.setImage(rentalFile);
//        employee.setRole(role);
//        return employee;
//    }

//    private RentalFile convertFileDTO(FileEntity fileEntity) {
//        return modelMapper.map(fileEntity, RentalFile.class);
//    }
}
