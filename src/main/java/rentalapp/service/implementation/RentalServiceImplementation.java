package rentalapp.service.implementation;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import rentalapp.dto.ClientDTO;
import rentalapp.dto.RentalDTO;
import rentalapp.dto.SearchResult;
import rentalapp.entity.RentalEntity;
import rentalapp.repository.RentalRepository;
import rentalapp.repository.UserRepository;
import rentalapp.repository.VehicleRepository;
import rentalapp.service.RentalService;

import java.util.List;

@Service
@Transactional
public class RentalServiceImplementation implements RentalService {
    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SearchResult getAllPageable(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<RentalEntity> rentalEntity = rentalRepository.findAll(pageable);

        List<RentalDTO> rentalDTOs = rentalEntity.stream()
                .map(etty -> {
                    var dto = modelMapper.map(etty, RentalDTO.class);
                    //TODO: See if there is more elegant solution
                    dto.setClient(modelMapper.map(etty.getClient(), ClientDTO.class));
                    return dto;
                })
                .toList();

        return new SearchResult(
                rentalDTOs,
                rentalEntity.getTotalElements(),
                rentalEntity.getTotalPages(),
                rentalEntity.getNumber(),
                rentalEntity.getSize()
        );
    }
}