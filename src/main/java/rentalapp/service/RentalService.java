package rentalapp.service;

import rentalapp.dto.SearchResult;

public interface RentalService {
    SearchResult getAllRentalsPaginated(int page, int size);
}
