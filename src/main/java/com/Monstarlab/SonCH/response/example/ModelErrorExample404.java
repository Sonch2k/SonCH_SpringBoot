package com.Monstarlab.SonCH.response.example;

import io.swagger.annotations.ApiModelProperty;

public class ModelErrorExample404 {
    @ApiModelProperty(value = "data",example = "")
    public Object data;
    @ApiModelProperty(value = "message",example = "Not Found,Try again!")
    public String message;
    @ApiModelProperty(value = "status",example = "403")
    public String status;
}
