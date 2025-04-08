package rentalapp.service;

import rentalapp.dto.MalfunctionDTO;
import rentalapp.dto.MalfunctionRequest;

import java.util.List;

public interface MalfunctionService {

    MalfunctionDTO create(MalfunctionRequest malfunctionRequest);

    List<MalfunctionDTO> getByVehicleId(Integer id);

    boolean deleteById(Integer id);

}
