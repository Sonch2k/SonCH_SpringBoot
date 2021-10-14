package com.Monstarlab.SonCH.response.example;

import io.swagger.annotations.ApiModelProperty;

public class ModelErrorExample401 {
    @ApiModelProperty(value = "data",example = "")
    public Object data;
    @ApiModelProperty(value = "message",example = "Unauthorization,Try again!")
    public String message;
    @ApiModelProperty(value = "status",example = "401")
    public String status;
}
