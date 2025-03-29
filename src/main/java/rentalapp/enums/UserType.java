package rentalapp.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import rentalapp.dto.ClientDTO;
import rentalapp.dto.EmployeeDTO;
import rentalapp.dto.UserDTO;
import rentalapp.entity.ClientEntity;
import rentalapp.entity.EmployeeEntity;
import rentalapp.entity.UserEntity;

import java.util.Arrays;

@RequiredArgsConstructor
public enum UserType {
    CLIENT(ClientDTO.class, ClientEntity.class),
    EMPLOYEE(EmployeeDTO.class, EmployeeEntity.class);

    @Getter
    private final Class<? extends UserDTO> dtoClass;

    @Getter
    private final Class<? extends UserEntity> ettyClass;

    public static UserType fromEttyClass(final Class<? extends UserEntity> ettyClass) {
        return Arrays.stream(values())
                .filter(type -> ettyClass.equals(type.getEttyClass()))
                .findFirst()
                .orElse(CLIENT);
    }
}
