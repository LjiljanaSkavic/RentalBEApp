package rentalapp.service.implementation;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import rentalapp.dto.RentalDTO;
import rentalapp.dto.RentalSearchResult;
import rentalapp.entity.RentalEntity;
import rentalapp.repository.RentalRepository;
import rentalapp.service.RentalService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RentalServiceImplementation implements RentalService {
    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RentalSearchResult getAllRentalsPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<RentalEntity> rentalEntity = rentalRepository.findAll(pageable);

        List<RentalDTO> rentalDTOs = rentalEntity.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        return new RentalSearchResult(
                rentalDTOs,
                rentalEntity.getTotalElements(),
                rentalEntity.getTotalPages(),
                rentalEntity.getNumber(),
                rentalEntity.getSize()
        );
    }

    private RentalDTO convertToDTO(RentalEntity rentalEntity) {
        return modelMapper.map(rentalEntity, RentalDTO.class);
    }
}