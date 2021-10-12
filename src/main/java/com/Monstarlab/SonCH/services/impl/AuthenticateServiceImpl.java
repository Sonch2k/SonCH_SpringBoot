package com.Monstarlab.SonCH.services.impl;

import com.Monstarlab.SonCH.configuration.CommonProperties;
import com.Monstarlab.SonCH.request.AuthRequest;
import com.Monstarlab.SonCH.response.BaseResponse;
import com.Monstarlab.SonCH.response.LoginResponse;
import com.Monstarlab.SonCH.response.information.LoginInfo;
import com.Monstarlab.SonCH.services.AuthenticateService;
import com.Monstarlab.SonCH.utils.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class AuthenticateServiceImpl implements AuthenticateService {
    private AuthenticationManager authenticationManager;
    private JwtUtils jwtUtils;
private CommonProperties commonProperties;
    @Override
    public LoginResponse performAuthenticate(AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword()
                )
        );
        Date now = new Date();
        Date expiration = new Date(now.getTime() + commonProperties.getExpiration());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken = jwtUtils.generateToken(authentication);
        LoginInfo loginInfo = new LoginInfo(jwtToken,expiration.toString());

        return new LoginResponse("200",loginInfo,"login success");
    }
}
