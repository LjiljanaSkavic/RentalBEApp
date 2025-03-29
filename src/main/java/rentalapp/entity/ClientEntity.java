package rentalapp.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "client")
public class ClientEntity extends UserEntity {
    @Basic
    @Column(name = "card_number")
    private String cardNumber;

    @Basic
    @Column(name = "is_blocked")
    private boolean isBlocked;
}
