package com.Monstarlab.SonCH.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Builder
@AllArgsConstructor
@Data
public class BaseResponse<T>{
    @ApiModelProperty(value = "status",example = "200")
    private String status;
    private T data;
    @ApiModelProperty(value = "message",example = "successfully!")
    private String message;

    public BaseResponse(final ResponseMessage responeMessage, Object... params) {
        this.message = responeMessage.getMessage(params);
        this.status = responeMessage.getStatus();
    }

}
