package rentalapp.dto;

import lombok.Data;

@Data
public class ManufacturerDTO {
    private int id;
    private String name;
    private String country;
    private String address;
    private String email;
    private String phone;
    private String fax;
}
