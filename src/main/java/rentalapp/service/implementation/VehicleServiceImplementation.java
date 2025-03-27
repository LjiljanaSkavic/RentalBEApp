package rentalapp.service.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import rentalapp.dto.VehicleDTO;
import rentalapp.dto.VehicleSearchResult;
import rentalapp.entity.VehicleEntity;
import rentalapp.enums.VehicleCategory;
import rentalapp.repository.VehicleRepository;
import rentalapp.repository.VehicleRepositoryFactory;
import rentalapp.service.VehicleService;

import java.util.List;

@Service
public class VehicleServiceImplementation implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private VehicleRepositoryFactory vehicleRepositoryFactory;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public VehicleSearchResult<? extends VehicleDTO> getAllVehiclesPaginated(int page, int size, VehicleCategory category) {

        Pageable pageable = PageRequest.of(page, size);
        Page<VehicleEntity> vehicleEntities = vehicleRepositoryFactory.get(category).findAllByIsDeletedFalse(pageable);

        List<? extends VehicleDTO> vehicleDTOs = vehicleEntities.stream()
                .map(obj -> modelMapper.map(obj, category.getDtoClass()))
                .toList();

        return new VehicleSearchResult<>(
                vehicleDTOs,
                vehicleEntities.getTotalElements(),
                vehicleEntities.getTotalPages(),
                vehicleEntities.getNumber(),
                vehicleEntities.getSize()
        );

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
