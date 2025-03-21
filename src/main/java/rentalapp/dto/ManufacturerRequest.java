package rentalapp.dto;

import lombok.Data;

@Data
public class ManufacturerRequest {
    private String name;
    private String country;
    private String address;
    private String email;
    private String phone;
    private String fax;
}
