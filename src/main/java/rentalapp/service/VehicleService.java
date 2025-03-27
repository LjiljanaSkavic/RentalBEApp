package rentalapp.service;

import rentalapp.dto.SearchResult;
import rentalapp.dto.VehicleDTO;
import rentalapp.dto.VehicleReqDTO;
import rentalapp.enums.VehicleCategory;

public interface VehicleService {
    SearchResult<? extends VehicleDTO> getAllVehiclesPaginated(int page, int size, VehicleCategory category);

    VehicleDTO create(VehicleReqDTO dto);

    VehicleDTO update(Integer id, VehicleReqDTO dto);

    VehicleDTO get(Integer id);

    boolean deleteVehicle(Integer id);
}