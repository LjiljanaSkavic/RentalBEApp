package rentalapp.service;

import rentalapp.dto.ManufacturerSearchResult;

public interface ManufacturerService {
    ManufacturerSearchResult getAllManufacturersPaginated(int page, int size);
}
