package com.example.android_record_shop.service;

import com.example.android_record_shop.model.Album;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface AlbumApiService {


//    @GET("albums")
//    Call<List<Album>> getAllAlbums();

    @GET("albums")
    Call<ResponseBody> getRawJson();
}
