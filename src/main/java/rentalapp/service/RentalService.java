package rentalapp.service;

import rentalapp.dto.SearchResult;

public interface RentalService {
    SearchResult getAllPageable(int page, int size);
}
