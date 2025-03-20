package rentalapp.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CarDTO extends VehicleDTO {
    private Timestamp acquisitionDate;
    private String description;
}
