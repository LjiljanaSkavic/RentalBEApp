package rentalapp.service;

import rentalapp.dto.SearchResult;
import rentalapp.dto.UserDTO;
import rentalapp.enums.UserType;

public interface UserService {
//    Employee loginEmployee(String username, String password);
//
//    Employee changePassword(Integer id, PasswordRequest passwordRequest);

    SearchResult<? extends UserDTO> getAll(int page, int size, UserType type);
}