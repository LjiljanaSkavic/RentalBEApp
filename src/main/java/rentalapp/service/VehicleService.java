package rentalapp.service;

import rentalapp.dto.VehicleReqDTO;
import rentalapp.dto.VehicleDTO;
import rentalapp.dto.VehicleSearchResult;
import rentalapp.enums.VehicleCategory;

public interface VehicleService {
    VehicleSearchResult<? extends VehicleDTO> getAllVehiclesPaginated(int page, int size, VehicleCategory category);

    VehicleDTO create(VehicleReqDTO dto);

    VehicleDTO update(Integer id, VehicleReqDTO dto);

    VehicleDTO get(Integer id);

    boolean deleteVehicle(Integer id);
}