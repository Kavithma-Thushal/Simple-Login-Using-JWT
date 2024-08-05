package lk.ijse.gdse66.jwt.security.auth.request;

import lombok.*;

/**
 * @author : Kavithma Thushal
 * @project : Simple-Login-Using-JWT
 * @since : 12:47 PM - 8/5/2024
 **/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SignIn {
    private String email;
    private String password;
}