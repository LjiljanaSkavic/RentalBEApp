package rentalapp.service.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import rentalapp.dto.ManufacturerDTO;
import rentalapp.dto.ManufacturerSearchResult;
import rentalapp.entity.ManufacturerEntity;
import rentalapp.repository.ManufacturerRepository;
import rentalapp.service.ManufacturerService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManufacturerServiceImplementation implements ManufacturerService {
    @Autowired
    private ManufacturerRepository manufacturerRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ManufacturerSearchResult getAllManufacturersPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ManufacturerEntity> manufacturerEntities = manufacturerRepository.findAll(pageable);

        List<ManufacturerDTO> manufacturerDTOs = manufacturerEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        return new ManufacturerSearchResult(
                manufacturerDTOs,
                manufacturerEntities.getTotalElements(),
                manufacturerEntities.getTotalPages(),
                manufacturerEntities.getNumber(),
                manufacturerEntities.getSize()
        );
    }

    private ManufacturerDTO convertToDTO(ManufacturerEntity manufacturerEntity) {
        return modelMapper.map(manufacturerEntity, ManufacturerDTO.class);
    }
}
