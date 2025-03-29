package rentalapp.dto;

import lombok.Data;

@Data
public class ClientDTO extends UserDTO {
    private String cardNumber;
    private boolean isBlocked;
}
