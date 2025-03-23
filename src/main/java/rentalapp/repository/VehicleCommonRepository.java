package rentalapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rentalapp.entity.VehicleEntity;

public interface VehicleCommonRepository {
    Page<VehicleEntity> findAllByIsDeletedFalse(Pageable page);
}
