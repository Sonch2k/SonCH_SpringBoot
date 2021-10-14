package com.Monstarlab.SonCH.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RegisterRequest {
    @ApiModelProperty(value = "username",example = "username")
    private String username;
    @ApiModelProperty(value = "password",example = "*******")
    private String password;
}
