package com.sga.ecommerce.service.user;

import com.sga.ecommerce.dto.SignupDTO;
import com.sga.ecommerce.dto.UserDTO;

public interface UserService {

    UserDTO createUser(SignupDTO signupDTO);

    boolean hasUserWithEmail(String email);
}
