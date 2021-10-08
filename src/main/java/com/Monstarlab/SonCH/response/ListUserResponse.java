package com.Monstarlab.SonCH.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class ListUserResponse {
    private String status;
    private List<Object> Data;
    private String message;
}
