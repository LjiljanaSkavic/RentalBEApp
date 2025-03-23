package rentalapp.service;

import rentalapp.dto.VehicleDTO;
import rentalapp.dto.VehicleSearchResult;
import rentalapp.enums.VehicleCategory;

public interface VehicleService {
    VehicleSearchResult<VehicleDTO> getAllVehiclesPaginated(int page, int size, VehicleCategory category);

    boolean deleteVehicle(Integer id);
}