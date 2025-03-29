package rentalapp.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phone;
    private Integer profilePictureId;
}

