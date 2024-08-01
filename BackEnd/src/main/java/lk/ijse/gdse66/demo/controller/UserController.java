package lk.ijse.gdse66.demo.controller;

import lk.ijse.gdse66.demo.security.auth.request.SignIn;
import lk.ijse.gdse66.demo.security.auth.request.SignUp;
import lk.ijse.gdse66.demo.security.auth.response.Token;
import lk.ijse.gdse66.demo.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<Token> signUp(@RequestBody SignUp signUp) {
        return ResponseEntity.ok(authenticationService.signUp(signUp));
    }

    @PostMapping("/signin")
    public ResponseEntity<Token> signIn(@RequestBody SignIn signIn) {
        return ResponseEntity.ok(authenticationService.signIn(signIn));
    }
}