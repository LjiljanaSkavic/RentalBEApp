package rentalapp.service;

import rentalapp.dto.ManufacturerDTO;
import rentalapp.dto.ManufacturerRequest;
import rentalapp.dto.SearchResult;

public interface ManufacturerService {
    SearchResult<ManufacturerDTO> getAllPageable(int page, int size);

    ManufacturerDTO update(Integer id, ManufacturerRequest manufacturerRequest);

    boolean delete(Integer id);

    ManufacturerDTO create(ManufacturerRequest manufacturerRequest);
}
