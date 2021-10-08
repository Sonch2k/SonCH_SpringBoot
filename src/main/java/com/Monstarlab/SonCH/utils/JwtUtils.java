package com.Monstarlab.SonCH.utils;


import com.Monstarlab.SonCH.configuration.CommonProperties;
import com.Monstarlab.SonCH.entity.User;
import com.Monstarlab.SonCH.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Objects;

@Component
@AllArgsConstructor
public class JwtUtils {
    private UserRepository userRepository;
    private CommonProperties commonProperties;

    public String generateToken(Authentication authentication) {
        User user = userRepository.findByUsername(authentication.getName());
        Date now = new Date();
        Date expiration = new Date(now.getTime() + commonProperties.getExpiration());
        String jwtToken = Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiration)
                .claim("id", user.getId())
                .signWith(SignatureAlgorithm.HS512, commonProperties.getSecret())
                .compact();
        return jwtToken;
    }

    public String parseeJWT(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (!header.isEmpty() && header.startsWith("Bearer ")) {
            return header.substring(7);
        }
        return null;
    }

    public Boolean validateJWT(String jwt) {
        Jwts.parser()
                .setSigningKey(commonProperties.getSecret())
                .parseClaimsJws(jwt);
        return true;
    }

    public String getUsername(String jwt) {
        String username = Jwts.parser()
                .setSigningKey(commonProperties.getSecret())
                .parseClaimsJws(jwt)
                .getBody()
                .getSubject();
        return username;
    }
}
