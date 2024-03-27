package com.elearningsystem.utils;

import com.elearningsystem.vm.common.message.ResponseMessage;
import com.elearningsystem.vm.common.message.ResponseMessageType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MessageUtils {

    public static ResponseMessage createErrorMessage(final String messageText) {
        return ResponseMessage.builder()
                .type(ResponseMessageType.ERROR)
                .logDate(Instant.now())
                .text(messageText)
                .build();
    }

    public static ResponseMessage createSuccessMessage(final String messageText) {
        return ResponseMessage.builder()
                .type(ResponseMessageType.SUCCESS)
                .logDate(Instant.now())
                .text(messageText)
                .build();
    }
}
