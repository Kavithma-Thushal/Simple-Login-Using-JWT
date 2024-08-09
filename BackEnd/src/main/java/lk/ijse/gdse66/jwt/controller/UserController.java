package lk.ijse.gdse66.jwt.controller;

import lk.ijse.gdse66.jwt.security.auth.request.SignIn;
import lk.ijse.gdse66.jwt.security.auth.request.SignUp;
import lk.ijse.gdse66.jwt.security.auth.response.JWTResponse;
import lk.ijse.gdse66.jwt.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Kavithma Thushal
 * @project : Simple-Login-Using-JWT
 * @since : 12:47 PM - 8/5/2024
 **/
@CrossOrigin
@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<JWTResponse> signUp(@RequestBody SignUp signUp) {
        return ResponseEntity.ok(authenticationService.signUp(signUp));
    }

    @PostMapping("/signin")
    public ResponseEntity<JWTResponse> signIn(@RequestBody SignIn signIn) {
        return ResponseEntity.ok(authenticationService.signIn(signIn));
    }
}