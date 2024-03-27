package com.elearningsystem.vm.common;

import com.elearningsystem.vm.common.message.ResponseMessage;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse {

    private List<ResponseMessage> messages = new ArrayList<>();

    public void addMessage(final ResponseMessage message){
        this.getMessages().add(message);
    }
}
