package rentalapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "manufacturer", schema = "rentaldb", catalog = "")
public class ManufacturerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "country")
    private String country;

    @Basic
    @Column(name = "address")
    private String address;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "phone")
    private String phone;

    @Basic
    @Column(name = "fax")
    private String fax;

    @Basic
    @Column(name = "is_deleted")
    private boolean isDeleted;
}
