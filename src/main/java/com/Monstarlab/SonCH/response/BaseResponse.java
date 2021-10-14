package com.Monstarlab.SonCH.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Builder
@AllArgsConstructor
@Data
public class BaseResponse<T>{
    private String status;
    private T data;
    private String message;

    public BaseResponse(final ResponseMessage responeMessage, Object... params) {
        this.message = responeMessage.getMessage(params);
        this.status = responeMessage.getStatus();
    }

}
