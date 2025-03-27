package rentalapp.dto;

import lombok.Data;
import rentalapp.enums.VehicleCategory;
import rentalapp.enums.VehicleStatus;

@Data
public class VehicleReqDTO {
    private VehicleCategory category;
    private String vehicleCode;
    private double purchasePrice;
    private String model;
    private VehicleStatus status;
    private Integer manufacturerId;
    private Integer vehiclePictureId;
    private String description;
}
