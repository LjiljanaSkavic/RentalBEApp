package rentalapp.service.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import rentalapp.dto.SearchResult;
import rentalapp.dto.VehicleDTO;
import rentalapp.dto.VehicleReqDTO;
import rentalapp.entity.FileEntity;
import rentalapp.entity.VehicleEntity;
import rentalapp.enums.VehicleCategory;
import rentalapp.repository.FileRepository;
import rentalapp.repository.VehicleRepository;
import rentalapp.repository.VehicleRepositoryFactory;
import rentalapp.service.VehicleService;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImplementation implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private VehicleRepositoryFactory vehicleRepositoryFactory;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private FileRepository fileRepository;

    @Override
    public SearchResult<? extends VehicleDTO> getAllPageable(int page, int size, VehicleCategory category) {

        Pageable pageable = PageRequest.of(page, size);
        Page<VehicleEntity> vehicleEntities = vehicleRepositoryFactory.get(category).findAllByIsDeletedFalse(pageable);

        List<? extends VehicleDTO> vehicleDTOs = vehicleEntities.stream()
                .map(obj -> modelMapper.map(obj, category.getDtoClass()))
                .toList();

        return new SearchResult<>(
                vehicleDTOs,
                vehicleEntities.getTotalElements(),
                vehicleEntities.getTotalPages(),
                vehicleEntities.getNumber(),
                vehicleEntities.getSize()
        );
    }

    @Override
    public VehicleDTO update(Integer id, VehicleReqDTO dto) {
        VehicleEntity vehicleEntity = vehicleRepository.findById(id).orElseThrow();

        if (dto.getVehiclePictureId() != vehicleEntity.getImage().getId()) {
            Optional<FileEntity> fileEntity = fileRepository.findById(dto.getVehiclePictureId());
            if (fileEntity.isPresent()) {
                vehicleEntity.setImage(fileEntity.get());
            }
        }

        modelMapper.map(dto, vehicleEntity);
        vehicleEntity.setId(id);
        vehicleRepository.save(vehicleEntity);
        return modelMapper.map(vehicleEntity, dto.getCategory().getDtoClass());
    }


    @Override
    public VehicleDTO get(Integer id) {
        VehicleEntity vehicleEntity = vehicleRepository.findById(id).orElseThrow();
        return modelMapper.map(
                vehicleEntity,
                VehicleCategory.fromEttyClass(vehicleEntity.getClass()).getDtoClass()
        );
    }

    @Override
    public VehicleDTO create(VehicleReqDTO dto) {
        VehicleEntity vehicleEntity = modelMapper.map(dto, dto.getCategory().getEttyClass());
        Optional<FileEntity> fileEntity = fileRepository.findById(dto.getVehiclePictureId());
        if (fileEntity.isPresent()) {
            vehicleEntity.setImage(fileEntity.get());
        }
        vehicleRepository.save(vehicleEntity);
        return modelMapper.map(vehicleEntity, dto.getCategory().getDtoClass());
    }

    @Override
    public boolean deleteVehicle(Integer id) {
        VehicleEntity vehicle = vehicleRepository.findById(id).orElse(null);
        if (vehicle == null) {
            return false;
        }
        vehicle.setDeleted(true);
        this.vehicleRepository.save(vehicle);
        return true;
    }
}
