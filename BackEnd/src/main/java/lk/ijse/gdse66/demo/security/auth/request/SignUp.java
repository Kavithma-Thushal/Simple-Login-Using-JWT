package lk.ijse.gdse66.demo.security.auth.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SignUp {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
}