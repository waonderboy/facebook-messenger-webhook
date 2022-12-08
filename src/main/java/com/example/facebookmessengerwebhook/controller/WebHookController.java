package com.example.facebookmessengerwebhook.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//https://ef6e-220-78-224-165.jp.ngrok.io/
@Slf4j
@RestController
public class WebHookController {

    @Value("${FACEBOOK_PAGE_ACCESS_TOKEN}")
    private String ACCESS_TOKEN;

    @PostMapping("/webhook")
    public ResponseEntity<Object> webhook(@RequestBody String requestBody) {
        log.info("messageBody={}", requestBody);


        return new ResponseEntity<>("EVENT_RECEIVED", HttpStatus.OK);
    }

    @GetMapping("/webhook")
    public ResponseEntity<Object> webhook(@RequestParam(name = "hub.verify_token") String token,
                                          @RequestParam(name = "hub.challenge") String challenge,
                                          @RequestParam(name = "hub.mode") String mode) {

        log.info("token={}", ACCESS_TOKEN);

        ResponseEntity<Object> response = null;

        if (mode != null && token != null && token != null) {

            // Checks the mode and token sent is correct
            if (mode.equals("subscribe") && token.equals(ACCESS_TOKEN)) {

                response = new ResponseEntity<>(challenge, HttpStatus.OK);
            } else {
                // Responds with '403 Forbidden' if verify tokens do not match
                response = new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        }
        return response;
    }

}
