package com.Monstarlab.SonCH.response.information;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginInfo {
    @ApiModelProperty(value = "token",example = "eyJhbGciOiJIUzUxMiJ9.eyJzdMTZ9.kx3W7BjwjEKtXRr7IOV24Hc3FpsTjbgflTxpA")
    private String token;
    @ApiModelProperty(value = "expiration",example = "Fri Oct 15 16:46:17 ICT 2009")
    private String expiration;
}
