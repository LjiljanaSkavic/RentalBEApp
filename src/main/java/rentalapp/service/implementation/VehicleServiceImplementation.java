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
import rentalapp.repository.CarRepository;
import rentalapp.repository.ElectricBikeRepository;
import rentalapp.repository.ElectricScooterRepository;
import rentalapp.repository.VehicleRepository;
import rentalapp.service.VehicleService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImplementation implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private ElectricBikeRepository electricBikeRepository;
    @Autowired
    private ElectricScooterRepository electricScooterRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public VehicleSearchResult<?> getAllVehiclesPaginated(int page, int size, String category) {

        if ("All".equals(category)) {
            Pageable pageable = PageRequest.of(page, size);
            Page<VehicleEntity> vehicleEntities = vehicleRepository.findAllByIsDeletedFalse(pageable);

            List<VehicleDTO> vehicleDTOs = vehicleEntities.stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());

            return new VehicleSearchResult<VehicleDTO>(
                    vehicleDTOs,
                    vehicleEntities.getTotalElements(),
                    vehicleEntities.getTotalPages(),
                    vehicleEntities.getNumber(),
                    vehicleEntities.getSize()
            );
        } else if ("Car".equals(category)) {
            Pageable pageable = PageRequest.of(page, size);
            Page<CarEntity> carEntities = carRepository.findAllByIsDeletedFalse(pageable);

            List<CarDTO> carDTOS = carEntities.stream()
                    .map(this::convertCarToDTO)
                    .collect(Collectors.toList());

            return new VehicleSearchResult<CarDTO>(
                    carDTOS,
                    carEntities.getTotalElements(),
                    carEntities.getTotalPages(),
                    carEntities.getNumber(),
                    carEntities.getSize()
            );
        } else if ("ElectricBike".equals(category)) {
            Pageable pageable = PageRequest.of(page, size);
            Page<ElectricBikeEntity> electricBikeEntities = electricBikeRepository.findAllByIsDeletedFalse(pageable);

            List<ElectricBikeDTO> electricBikeDTOS = electricBikeEntities.stream()
                    .map(this::convertElectricBikeToDTO)
                    .collect(Collectors.toList());

            return new VehicleSearchResult<ElectricBikeDTO>(
                    electricBikeDTOS,
                    electricBikeEntities.getTotalElements(),
                    electricBikeEntities.getTotalPages(),
                    electricBikeEntities.getNumber(),
                    electricBikeEntities.getSize()
            );
        } else if ("ElectricScooter".equals(category)) {
            Pageable pageable = PageRequest.of(page, size);
            Page<ElectricScooterEntity> electricScooters = electricScooterRepository.findAllByIsDeletedFalse(pageable);

            List<ElectricScooterDTO> electricScooterDTOS = electricScooters.stream()
                    .map(this::convertElectricScooterToDTO)
                    .collect(Collectors.toList());

            return new VehicleSearchResult<ElectricScooterDTO>(
                    electricScooterDTOS,
                    electricScooters.getTotalElements(),
                    electricScooters.getTotalPages(),
                    electricScooters.getNumber(),
                    electricScooters.getSize()
            );
        } else {
            return new VehicleSearchResult<>(new ArrayList<>(), 0, 0, 0, 0);
        }
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
