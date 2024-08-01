package lk.ijse.gdse66.demo.repo;

import lk.ijse.gdse66.demo.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<CustomerEntity, String> {
}