package lk.ijse.gdse66.jwt.repo;

import lk.ijse.gdse66.jwt.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Kavithma Thushal
 * @project : Simple-Login-Using-JWT
 * @since : 12:47 PM - 8/5/2024
 **/
public interface CustomerRepo extends JpaRepository<CustomerEntity, String> {
}