package rentalapp.controller;

import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rentalapp.dto.*;
import rentalapp.enums.UserType;
import rentalapp.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public SearchResult<? extends UserDTO> getAll(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "10") int size,
                                                  @RequestParam @Nullable UserType type) {
        return userService.getAllPageable(page, size, type);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        try {
            String username = loginRequest.getUsername();
            String password = loginRequest.getPassword();

            EmployeeDTO employee = userService.loginEmployee(username, password);
            if (employee != null) {
                return ResponseEntity.ok(employee);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while logging in.");
        }
    }

    @PostMapping("/change-password/{id}")
    public EmployeeDTO changePassword(@PathVariable Integer id, @RequestBody PasswordRequest passwordRequest) {
        try {
            return userService.changePassword(id, passwordRequest);
        } catch (Exception e) {
            throw e;
        }
    }

    @PostMapping("/manage-block/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.manageBlock(id));
    }
}
