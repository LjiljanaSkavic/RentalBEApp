package rentalapp.dto;

import lombok.Data;

@Data
public class ElectricBikeDTO extends VehicleDTO {
    private Integer rangePerCharge;
}
