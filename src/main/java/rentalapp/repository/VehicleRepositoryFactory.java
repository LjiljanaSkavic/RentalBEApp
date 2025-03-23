package rentalapp.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import rentalapp.enums.VehicleCategory;

@Component
@RequiredArgsConstructor
public class VehicleRepositoryFactory {

    private final CarRepository carRepository;
    private final ElectricBikeRepository eBikeRepository;
    private final ElectricScooterRepository eScooterRepository;
    private final VehicleRepository vehicleRepository;

    public VehicleCommonRepository get(VehicleCategory category) {
        if (category == null) {
            return vehicleRepository;
        }
        return switch (category) {
            case CAR -> carRepository;
            case E_BIKE -> eBikeRepository;
            case E_SCOOTER -> eScooterRepository;
            default -> vehicleRepository;
        };
    }
}
