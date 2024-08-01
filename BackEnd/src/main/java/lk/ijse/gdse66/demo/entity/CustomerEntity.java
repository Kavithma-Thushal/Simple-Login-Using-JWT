package lk.ijse.gdse66.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    private String id;
    private String name;
    private String address;
}