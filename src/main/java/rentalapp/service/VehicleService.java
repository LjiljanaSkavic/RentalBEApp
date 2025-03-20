package rentalapp.service;

import rentalapp.dto.VehicleSearchResult;

public interface VehicleService {
    VehicleSearchResult getAllVehiclesPaginated(int page, int size);
}