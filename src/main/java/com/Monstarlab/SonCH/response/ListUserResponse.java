package com.Monstarlab.SonCH.response;

import com.Monstarlab.SonCH.entity.User;
import com.Monstarlab.SonCH.repository.UserRepository;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class ListUserResponse {
    @ApiModelProperty(value = "status",example = "200")
    private String status;
    @ApiModelProperty(value = "data",example = "List all User")
    private List<Object> data;
    @ApiModelProperty(value = "message",example = "[\n" +
            "      {\n" +
            "        \"id\": 1,\n" +
            "        \"username\": \"ahihi\",\n" +
            "        \"password\": \"{bcrypt}$2a$10$MWXDCK9N2mCyCkmFHFHXpO8nCBz3NOsu/4sCHPnS5R/z49uwr.PWa\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 15,\n" +
            "        \"username\": \"ProSon\",\n" +
            "        \"password\": \"{bcrypt}$2a$10$81DowPUV4rkKu6fweAaa.OHqr1xqfxgTpRTFUoe7j7h/v57xjb0/S\"\n" +
            "      }\n"+
            "      ]"
    )
    private String message;
}
