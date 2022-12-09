package com.example.facebookmessengerwebhook.infra;


import com.example.facebookmessengerwebhook.command.MessengerApiCommand;
import com.example.facebookmessengerwebhook.infra.retrofit.RetrofitUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessengerApiCaller {
    private final RetrofitUtils retrofitUtils;
    private final RetrofitMessengerApi messengerApiCaller;

    public MessengerApiResponse.send sendMessage(String token, MessengerApiCommand.send request) {
        var call = messengerApiCaller.sendMessage(request, token);
        return retrofitUtils.responseSync(call)
                .orElseThrow(RuntimeException::new);
    }

}
