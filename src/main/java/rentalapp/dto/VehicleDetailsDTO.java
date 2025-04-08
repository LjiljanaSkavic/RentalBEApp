package rentalapp.dto;

import lombok.Data;

import java.util.List;

@Data
public class VehicleDetailsDTO extends VehicleDTO {
    private List<RentalDTO> rentals;
    private List<MalfunctionDTO> malfunctions;
}
