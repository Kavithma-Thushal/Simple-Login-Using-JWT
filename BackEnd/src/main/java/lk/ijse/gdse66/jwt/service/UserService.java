package lk.ijse.gdse66.jwt.service;

import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author : Kavithma Thushal
 * @project : Simple-Login-Using-JWT
 * @since : 12:47 PM - 8/5/2024
 **/
public interface UserService {
    UserDetailsService userDetailService();
}