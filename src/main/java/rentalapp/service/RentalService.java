package rentalapp.service;

import rentalapp.dto.RentalDTO;
import rentalapp.dto.SearchResult;

import java.util.List;

public interface RentalService {
    SearchResult getAllPageable(int page, int size);

    List<RentalDTO> getAllByVehicleId(Integer id);
}
