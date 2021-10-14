package com.Monstarlab.SonCH.response.example;

import io.swagger.annotations.ApiModelProperty;

public class ModelErrorExample403 {
    public String data;
    @ApiModelProperty(value = "message",example = "Forbidden,Try again!")
    public String message;
    @ApiModelProperty(value = "status",example = "403")
    public String status;
}
