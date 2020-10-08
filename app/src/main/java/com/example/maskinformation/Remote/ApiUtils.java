package com.example.maskinformation.Remote;

import retrofit2.Retrofit;

public class ApiUtils {

    public static final String BASE_URL = "/*your web service url*/";
   
    public static MaskeService getMaskeService(){
        return RetrofitClient.getClient(BASE_URL).create(MaskeService.class);
    }
}
