package com.example.facebookmessengerwebhook.controller;

import com.example.facebookmessengerwebhook.command.MessengerApiCommand;
import com.example.facebookmessengerwebhook.infra.MessengerApiCaller;
import com.example.facebookmessengerwebhook.infra.MessengerApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
public class IndexController {
    @Value("${FACEBOOK_PAGE_ACCESS_TOKEN}")
    private String ACCESS_TOKEN;
    private final MessengerApiCaller messengerApiCaller;

    @GetMapping("/")
    public ResponseEntity<MessengerApiResponse.send> index(){

        MessengerApiCommand.Recipient recipient = MessengerApiCommand.Recipient.builder().id(5696429073727123L).build();
        MessengerApiCommand.MessageBody messageBody = MessengerApiCommand.MessageBody.builder().text("So hard").build();
        MessengerApiCommand.send request = MessengerApiCommand.send
                .builder()
                .recipient(recipient)
                .messaging_type("RESPONSE")
                .message(messageBody)
                .build();

        MessengerApiResponse.send response = messengerApiCaller.sendMessage(ACCESS_TOKEN, request);

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
