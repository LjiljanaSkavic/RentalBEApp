package rentalapp.service;

import rentalapp.dto.RentalSearchResult;

public interface RentalService {
    RentalSearchResult getAllRentalsPaginated(int page, int size);
}
