package rentalapp.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import rentalapp.dto.CarDTO;
import rentalapp.dto.ElectricBikeDTO;
import rentalapp.dto.ElectricScooterDTO;
import rentalapp.dto.VehicleDTO;
import rentalapp.entity.CarEntity;
import rentalapp.entity.ElectricBikeEntity;
import rentalapp.entity.ElectricScooterEntity;
import rentalapp.entity.VehicleEntity;

import java.util.Arrays;

@RequiredArgsConstructor
public enum VehicleCategory {
    CAR(CarDTO.class, CarEntity.class),
    E_SCOOTER(ElectricScooterDTO.class, ElectricScooterEntity.class),
    E_BIKE(ElectricBikeDTO.class, ElectricBikeEntity.class);

    @Getter
    private final Class<? extends VehicleDTO> dtoClass;
    @Getter
    private final Class<? extends VehicleEntity> ettyClass;

    public static VehicleCategory fromEttyClass(final Class<? extends VehicleEntity> ettyClass) {
        return Arrays.stream(values())
                .filter(cat -> ettyClass.equals(cat.getEttyClass()))
                .findFirst()
                .orElse(CAR);
    }
}
