package rentalapp.service;

import rentalapp.dto.ManufacturerDTO;
import rentalapp.dto.ManufacturerRequest;
import rentalapp.dto.ManufacturerSearchResult;

public interface ManufacturerService {
    ManufacturerSearchResult getAllManufacturersPaginated(int page, int size);

    ManufacturerDTO updateManufacturer(Integer id, ManufacturerRequest manufacturerRequest);

    boolean deleteManufacturer(Integer id);

    ManufacturerDTO createManufacturer(ManufacturerRequest manufacturerRequest);
}
