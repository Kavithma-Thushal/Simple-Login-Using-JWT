package lk.ijse.gdse66.demo.service;

import lk.ijse.gdse66.demo.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {

    void Save(UserDTO userDTO);

    UserDetailsService userDetailService();
}