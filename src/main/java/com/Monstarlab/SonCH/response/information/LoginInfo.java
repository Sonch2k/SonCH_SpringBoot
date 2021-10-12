package com.Monstarlab.SonCH.response.information;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginInfo {
    private String token;
    private String expiration;
}
