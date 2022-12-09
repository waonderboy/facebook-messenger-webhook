package com.example.facebookmessengerwebhook.infra;

import com.example.facebookmessengerwebhook.command.MessengerApiCommand;
import retrofit2.Call;
import retrofit2.http.*;

public interface RetrofitMessengerApi {

    @POST("/me/messages")
    Call<MessengerApiResponse.send> sendMessage(@Body MessengerApiCommand.send request, @Query("access_token") String token);

}
