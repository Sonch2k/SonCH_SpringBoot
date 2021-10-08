package com.Monstarlab.SonCH.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class Response {
    private String status;
    private List<Object> Data;
    private String message;

    public Response(final ResponseMessage responeMessage, Object... params) {
        this.Data=null;
        this.message = responeMessage.getMessage(params);
        this.status = responeMessage.getStatus();
    }
}
