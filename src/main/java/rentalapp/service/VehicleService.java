package rentalapp.service;

import rentalapp.dto.SearchResult;
import rentalapp.dto.VehicleDTO;
import rentalapp.dto.VehicleDetailsDTO;
import rentalapp.dto.VehicleReqDTO;
import rentalapp.enums.VehicleCategory;

public interface VehicleService {
    SearchResult<? extends VehicleDTO> getAllPageable(int page, int size, VehicleCategory category);

    VehicleDTO create(VehicleReqDTO dto);

    VehicleDTO update(Integer id, VehicleReqDTO dto);

    VehicleDTO get(Integer id);

    VehicleDetailsDTO getDetails(Integer id);

    boolean deleteVehicle(Integer id);
}