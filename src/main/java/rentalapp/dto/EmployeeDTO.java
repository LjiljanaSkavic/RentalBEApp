package rentalapp.dto;

import lombok.Data;

@Data
public class EmployeeDTO extends UserDTO {
    private String role;
    private boolean isDeleted;
}
