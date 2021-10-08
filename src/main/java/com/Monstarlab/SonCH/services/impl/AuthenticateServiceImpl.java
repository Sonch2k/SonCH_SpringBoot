package com.Monstarlab.SonCH.services.impl;

import com.Monstarlab.SonCH.repository.UserRepository;
import com.Monstarlab.SonCH.request.AuthRequest;
import com.Monstarlab.SonCH.response.Response;
import com.Monstarlab.SonCH.services.AuthenticateService;
import com.Monstarlab.SonCH.utils.JwtUtils;
import com.nimbusds.jose.proc.SecurityContext;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor
public class AuthenticateServiceImpl implements AuthenticateService {
    private AuthenticationManager authenticationManager;
    private JwtUtils jwtUtils;

    @Override
    public Response performAuthenticate(AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken = jwtUtils.generateToken(authentication);
        Response response = Response.builder()
                .Data(Collections.singletonList(jwtToken))
                .status("200")
                .message("Success Authenticate")
                .build();
        return response;
    }
}
