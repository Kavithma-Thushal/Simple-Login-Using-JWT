package lk.ijse.gdse66.jwt.service;

import lk.ijse.gdse66.jwt.security.auth.request.SignIn;
import lk.ijse.gdse66.jwt.security.auth.request.SignUp;
import lk.ijse.gdse66.jwt.security.auth.response.Response;

/**
 * @author : Kavithma Thushal
 * @project : Simple-Login-Using-JWT
 * @since : 12:47 PM - 8/5/2024
 **/
public interface AuthenticationService {

    Response signUp(SignUp signUp);

    Response signIn(SignIn signIn);
}