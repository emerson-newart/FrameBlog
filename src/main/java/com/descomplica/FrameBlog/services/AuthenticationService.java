package com.descomplica.FrameBlog.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.descomplica.FrameBlog.request.AuthRequest;

public interface AuthenticationService extends UserDetailsService {

    String getToken(AuthRequest auth);

    String validateJwtToken(String token);
}
