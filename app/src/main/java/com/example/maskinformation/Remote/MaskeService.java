package com.example.maskinformation.Remote;

import com.example.maskinformation.Model.MaskeModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MaskeService {

    @GET("api/maske/find/{barkod}")
    Call<MaskeModel> findbarkod(@Path("barkod") String barkod);

    @GET("api/maske/findall")
    Call<List<MaskeModel>> findall();

}
