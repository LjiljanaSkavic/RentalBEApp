package rentalapp.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import rentalapp.dto.CarDTO;
import rentalapp.dto.ElectricBikeDTO;
import rentalapp.dto.ElectricScooterDTO;
import rentalapp.dto.VehicleDTO;

@RequiredArgsConstructor
public enum VehicleCategory {
    CAR(CarDTO.class),
    E_SCOOTER(ElectricScooterDTO.class),
    E_BIKE(ElectricBikeDTO.class),;

    @Getter
    private final Class<? extends VehicleDTO> dtoClass;
}
