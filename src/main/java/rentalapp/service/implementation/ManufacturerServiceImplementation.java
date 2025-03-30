package rentalapp.service.implementation;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import rentalapp.dto.ManufacturerDTO;
import rentalapp.dto.ManufacturerRequest;
import rentalapp.dto.SearchResult;
import rentalapp.entity.ManufacturerEntity;
import rentalapp.repository.ManufacturerRepository;
import rentalapp.service.ManufacturerService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ManufacturerServiceImplementation implements ManufacturerService {
    @Autowired
    private ManufacturerRepository manufacturerRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SearchResult<ManufacturerDTO> getAllPageable(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ManufacturerEntity> manufacturerEntities = manufacturerRepository.findAllByIsDeletedFalse(pageable);

        List<ManufacturerDTO> manufacturerDTOs = manufacturerEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        return new SearchResult<ManufacturerDTO>(
                manufacturerDTOs,
                manufacturerEntities.getTotalElements(),
                manufacturerEntities.getTotalPages(),
                manufacturerEntities.getNumber(),
                manufacturerEntities.getSize()
        );
    }

    public ManufacturerDTO create(ManufacturerRequest manufacturerRequest) {
        var manufacturer = modelMapper.map(manufacturerRequest, ManufacturerEntity.class);
        ManufacturerEntity savedManufacturerEntity = manufacturerRepository.save(manufacturer);
        return convertToDTO(savedManufacturerEntity);
    }

    public ManufacturerDTO update(Integer id, ManufacturerRequest manufacturerRequest) {
        ManufacturerEntity manufacturer = manufacturerRepository.findById(id).orElse(null);
        if (manufacturer == null) {
            return null;
        }
        modelMapper.map(manufacturerRequest, manufacturer);
        ManufacturerEntity updatedManufacturerEntity = this.manufacturerRepository.save(manufacturer);
        return convertToDTO(updatedManufacturerEntity);
    }

    public boolean delete(Integer id) {
        ManufacturerEntity manufacturer = manufacturerRepository.findById(id).orElse(null);
        if (manufacturer == null) {
            return false;
        }

        manufacturer.setDeleted(true);
        try {
            this.manufacturerRepository.save(manufacturer);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private ManufacturerDTO convertToDTO(ManufacturerEntity manufacturerEntity) {
        return modelMapper.map(manufacturerEntity, ManufacturerDTO.class);
    }
}
