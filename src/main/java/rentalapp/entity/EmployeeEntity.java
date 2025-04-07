package rentalapp.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "employee")
public class EmployeeEntity extends UserEntity {
    @Basic
    @Column(name = "role")
    private String role;

    @Basic
    @Column(name = "is_deleted")
    private boolean isDeleted;
}
