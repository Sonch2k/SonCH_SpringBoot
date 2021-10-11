package com.Monstarlab.SonCH.services;

import com.Monstarlab.SonCH.request.AuthRequest;
import com.Monstarlab.SonCH.response.BaseResponse;
import com.Monstarlab.SonCH.response.LoginResponse;
import org.springframework.security.core.AuthenticationException;

public interface AuthenticateService {
    public LoginResponse performAuthenticate(AuthRequest authRequest)throws AuthenticationException;
}
