package com.example.facebookmessengerwebhook.infra;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * {
 *   "recipient_id": "5696429073727123",
 *   "message_id": "m_nnLmU2kqPU3spNob8VPn7orcAEzdQi29ESNX8xJ4uhfQGxpbRUWoNzxPW2XIFXYRKiFSn-26SNYqUmnxZS3R_Q"
 * }
 */
public class MessengerApiResponse {

    @Getter
    @Builder
    @ToString
    public static class send {
        @JsonProperty("recipient_id")
        private final Long recipient;
        @JsonProperty("message_id")
        private final String messageId;
    }
}
