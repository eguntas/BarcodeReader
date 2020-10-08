package com.example.maskinformation.Remote;

import retrofit2.Retrofit;

public class ApiUtils {

    public static final String BASE_URL = "http://maskinformationapi.isko.com.tr/";
    //"http://10.30.25.23:4000/"

    public static MaskeService getMaskeService(){
        return RetrofitClient.getClient(BASE_URL).create(MaskeService.class);
    }
}
