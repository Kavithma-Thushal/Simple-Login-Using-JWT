package lk.ijse.gdse66.jwt.service.impl;

import lk.ijse.gdse66.jwt.dto.UserDTO;
import lk.ijse.gdse66.jwt.entity.UserEntity;
import lk.ijse.gdse66.jwt.repo.UserRepo;
import lk.ijse.gdse66.jwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author : Kavithma Thushal
 * @project : Simple-Login-Using-JWT
 * @since : 12:47 PM - 8/5/2024
 **/
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final ModelMapper mapper;

    @Override
    public void Save(UserDTO userDTO) {
        userRepo.save(mapper.map(userDTO, UserEntity.class));
    }

    @Override
    public UserDetailsService userDetailService() {
        return username -> userRepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found...!"));
    }
}