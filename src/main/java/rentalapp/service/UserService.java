package rentalapp.service;

import rentalapp.dto.EmployeeDTO;
import rentalapp.dto.PasswordRequest;
import rentalapp.dto.SearchResult;
import rentalapp.dto.UserDTO;
import rentalapp.enums.UserType;

public interface UserService {
    EmployeeDTO loginEmployee(String username, String password);


    SearchResult<? extends UserDTO> getAllPageable(int page, int size, UserType type);

    EmployeeDTO changePassword(Integer id, PasswordRequest passwordRequest);
}