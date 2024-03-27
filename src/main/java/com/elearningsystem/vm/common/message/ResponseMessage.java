package com.elearningsystem.vm.common.message;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Builder
@Data
//@Schema(description = "Representation of a response message.") TODO: remove if not required
public class ResponseMessage {

    // @Schema(description = "The text of this message", example = "Unable to save the resource, please try again.") TODO: remove if not required
    private String text;

    private Instant logDate;

    private ResponseMessageType type;
}
