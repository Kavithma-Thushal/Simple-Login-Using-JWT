package lk.ijse.gdse66.demo.service;

import lk.ijse.gdse66.demo.security.auth.request.SignIn;
import lk.ijse.gdse66.demo.security.auth.request.SignUp;
import lk.ijse.gdse66.demo.security.auth.response.Token;

public interface AuthenticationService {

    Token signUp(SignUp signUp);

    Token signIn(SignIn signIn);
}