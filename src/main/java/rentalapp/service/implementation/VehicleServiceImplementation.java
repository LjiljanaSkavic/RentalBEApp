package rentalapp.service.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import rentalapp.dto.*;
import rentalapp.entity.CarEntity;
import rentalapp.entity.ElectricBikeEntity;
import rentalapp.entity.ElectricScooterEntity;
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
    public VehicleSearchResult<VehicleDTO> getAllVehiclesPaginated(int page, int size, VehicleCategory category) {

            Pageable pageable = PageRequest.of(page, size);
            Page<VehicleEntity> vehicleEntities = vehicleRepositoryFactory.get(category).findAllByIsDeletedFalse(pageable);

            List<VehicleDTO> vehicleDTOs = vehicleEntities.stream()
                    .map(obj -> modelMapper.map(obj, VehicleDTO.class))
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
        VehicleEntity manufacturer = vehicleRepository.findById(id).orElse(null);
        if (manufacturer == null) {
            return false;
        }

        manufacturer.setDeleted(true);
        try {
            this.vehicleRepository.save(manufacturer);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private VehicleDTO convertToDTO(VehicleEntity vehicleEntity) {
        VehicleDTO dto = modelMapper.map(vehicleEntity, VehicleDTO.class);

        if (vehicleEntity instanceof CarEntity) {
            CarDTO carDTO = modelMapper.map(vehicleEntity, CarDTO.class);
            carDTO.setAcquisitionDate(((CarEntity) vehicleEntity).getAcquisitionDate());
            carDTO.setDescription(((CarEntity) vehicleEntity).getDescription());
            return carDTO;
        } else if (vehicleEntity instanceof ElectricBikeEntity) {
            ElectricBikeDTO bikeDTO = modelMapper.map(vehicleEntity, ElectricBikeDTO.class);
            Integer rangePerCharge = ((ElectricBikeEntity) vehicleEntity).getRangePerCharge();
            bikeDTO.setRangePerCharge(rangePerCharge != null ? rangePerCharge : 0);
            return bikeDTO;
        } else if (vehicleEntity instanceof ElectricScooterEntity) {
            ElectricScooterDTO scooterDTO = modelMapper.map(vehicleEntity, ElectricScooterDTO.class);
            Integer maxSpeed = ((ElectricScooterEntity) vehicleEntity).getMaxSpeed();
            scooterDTO.setMaxSpeed(maxSpeed != null ? maxSpeed : 0);
            return scooterDTO;
        }
        return dto;
    }

    private CarDTO convertCarToDTO(CarEntity carEntity) {
        return modelMapper.map(carEntity, CarDTO.class);
    }

    private ElectricBikeDTO convertElectricBikeToDTO(ElectricBikeEntity electricBikeEntity) {
        return modelMapper.map(electricBikeEntity, ElectricBikeDTO.class);
    }

    private ElectricScooterDTO convertElectricScooterToDTO(ElectricScooterEntity electricScooterEntity) {
        return modelMapper.map(electricScooterEntity, ElectricScooterDTO.class);
    }
}
