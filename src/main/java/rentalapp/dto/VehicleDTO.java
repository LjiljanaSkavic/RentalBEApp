package rentalapp.dto;

import lombok.Data;
import rentalapp.enums.VehicleStatus;

import java.util.List;

@Data
public class VehicleDTO {
    private Integer id;
    private String vehicleCode;
    private double purchasePrice;
    private String model;
    private VehicleStatus status;
    private boolean isDeleted;
    private Integer manufacturerId;
    private RentalFile image;
    private List<RentalDTO> rentals;
    private List<MalfunctionDTO> malfunctions;
}