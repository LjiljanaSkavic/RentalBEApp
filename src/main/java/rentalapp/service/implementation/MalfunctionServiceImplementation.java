package rentalapp.service.implementation;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rentalapp.dto.MalfunctionDTO;
import rentalapp.dto.MalfunctionRequest;
import rentalapp.entity.MalfunctionEntity;
import rentalapp.repository.MalfunctionRepository;
import rentalapp.service.MalfunctionService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MalfunctionServiceImplementation implements MalfunctionService {

    @Autowired
    private MalfunctionRepository malfunctionRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MalfunctionDTO create(MalfunctionRequest malfunctionRequest) {
        MalfunctionEntity malfunctionEntity = modelMapper.map(malfunctionRequest, MalfunctionEntity.class);
        MalfunctionEntity savedMalfunction = malfunctionRepository.save(malfunctionEntity);
        return modelMapper.map(savedMalfunction, MalfunctionDTO.class);
    }

    @Override
    public List<MalfunctionDTO> getByVehicleId(Integer id) {
        List<MalfunctionEntity> malfunctionEntities = this.malfunctionRepository.findAllByVehicleId(id);

        List<MalfunctionDTO> malfunctions = malfunctionEntities.stream()
                .map(entity -> modelMapper.map(entity, MalfunctionDTO.class))
                .collect(Collectors.toList());

        return malfunctions;
    }


    @Override
    public boolean deleteById(Integer id) {
        MalfunctionEntity malfunctionEntity = malfunctionRepository.findById(id).orElse(null);
        if (malfunctionEntity == null) {
            return false;
        }

        malfunctionEntity.setDeleted(true);
        try {
            this.malfunctionRepository.save(malfunctionEntity);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
