package rentalapp.dto;

import lombok.Data;
import rentalapp.enums.VehicleStatus;

@Data
public class VehicleDTO {
    private Integer id;
    private String vehicleCode;
    private double purchasePrice;
    private String model;
    private VehicleStatus status;
    private boolean isDeleted;
    private Integer manufacturerId;
    private Integer vehiclePictureId;
}