package com.Monstarlab.SonCH.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AuthRequest {
    @ApiModelProperty(value = "username",example = "username")
    private String username;
    @ApiModelProperty(value = "password",example = "*******")
    private String password;
}
