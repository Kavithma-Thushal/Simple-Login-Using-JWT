package lk.ijse.gdse66.jwt.service.impl;

import lk.ijse.gdse66.jwt.security.auth.request.SignIn;
import lk.ijse.gdse66.jwt.security.auth.request.SignUp;
import lk.ijse.gdse66.jwt.security.auth.response.JWTResponse;
import lk.ijse.gdse66.jwt.dto.UserDTO;
import lk.ijse.gdse66.jwt.entity.UserEntity;
import lk.ijse.gdse66.jwt.repo.UserRepo;
import lk.ijse.gdse66.jwt.service.AuthenticationService;
import lk.ijse.gdse66.jwt.service.JwtService;
import lk.ijse.gdse66.jwt.entity.enums.Role;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author : Kavithma Thushal
 * @project : Simple-Login-Using-JWT
 * @since : 12:47 PM - 8/5/2024
 **/
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    @Override
    public JWTResponse signUp(SignUp signUp) {
        UserDTO userDTO = UserDTO.builder()
                .id(UUID.randomUUID().toString())
                .name(signUp.getName())
                .email(signUp.getEmail())
                .password(passwordEncoder.encode(signUp.getPassword()))
                .role(Role.valueOf(signUp.getRole()))
                .build();
        UserEntity signUpUser = userRepo.save(modelMapper.map(userDTO, UserEntity.class));
        String generatedToken = jwtService.generateToken(signUpUser);
        return JWTResponse.builder().token(generatedToken).build();
    }

    @Override
    public JWTResponse signIn(SignIn signIn) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signIn.getEmail(), signIn.getPassword()));
        UserEntity signInUser = userRepo.findByEmail(signIn.getEmail()).orElseThrow(() -> new UsernameNotFoundException("User Not Found...!"));
        String generatedToken = jwtService.generateToken(signInUser);
        return JWTResponse.builder().token(generatedToken).build();
    }
}