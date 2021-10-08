package com.Monstarlab.SonCH.services;

import com.Monstarlab.SonCH.request.AuthRequest;
import com.Monstarlab.SonCH.response.Response;
import org.springframework.security.core.AuthenticationException;

public interface AuthenticateService {
    public Response performAuthenticate(AuthRequest authRequest)throws AuthenticationException;
}
