package lk.ijse.gdse66.demo.dto;

import lk.ijse.gdse66.demo.entity.enums.Role;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
}
