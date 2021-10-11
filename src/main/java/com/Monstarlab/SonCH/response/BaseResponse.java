package com.Monstarlab.SonCH.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Builder
@AllArgsConstructor
@Data
public class BaseResponse{
    private String status;
    private Object Data;
    private String message;

    public BaseResponse(final ResponseMessage responeMessage, Object... params) {
        this.message = responeMessage.getMessage(params);
        this.status = responeMessage.getStatus();
    }

}
