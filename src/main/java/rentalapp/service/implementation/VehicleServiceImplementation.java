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
import rentalapp.repository.VehicleRepository;
import rentalapp.service.VehicleService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImplementation implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public VehicleSearchResult getAllVehiclesPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<VehicleEntity> vehicleEntities = vehicleRepository.findAll(pageable);

        List<VehicleDTO> vehicleDTOs = vehicleEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        return new VehicleSearchResult(
                vehicleDTOs,
                vehicleEntities.getTotalElements(),
                vehicleEntities.getTotalPages(),
                vehicleEntities.getNumber(),
                vehicleEntities.getSize()
        );

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
}
