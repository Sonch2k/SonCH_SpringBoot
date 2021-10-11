package com.Monstarlab.SonCH.services;

import com.Monstarlab.SonCH.request.AuthRequest;
import com.Monstarlab.SonCH.response.BaseResponse;
import org.springframework.security.core.AuthenticationException;

public interface AuthenticateService {
    public BaseResponse performAuthenticate(AuthRequest authRequest)throws AuthenticationException;
}
