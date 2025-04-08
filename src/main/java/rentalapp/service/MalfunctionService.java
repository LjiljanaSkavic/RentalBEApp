package rentalapp.service;

import rentalapp.dto.MalfunctionDTO;
import rentalapp.dto.MalfunctionRequest;

public interface MalfunctionService {

    MalfunctionDTO create(MalfunctionRequest malfunctionRequest);

    boolean deleteById(Integer id);

}
