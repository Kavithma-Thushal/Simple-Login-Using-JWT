package lk.ijse.gdse66.demo.security.auth.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SignIn {
    private String email;
    private String password;
}