package lk.ijse.gdse66.demo.service.impl;

import lk.ijse.gdse66.demo.dto.UserDTO;
import lk.ijse.gdse66.demo.entity.UserEntity;
import lk.ijse.gdse66.demo.repo.UserRepo;
import lk.ijse.gdse66.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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