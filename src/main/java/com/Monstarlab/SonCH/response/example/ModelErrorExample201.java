package com.Monstarlab.SonCH.response.example;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ModelErrorExample201 {

    public String data;
    @ApiModelProperty(value = "message",example = "created success")
    public String message;
    @ApiModelProperty(value = "status",example = "200")
    public String status;
}
