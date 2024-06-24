package com.example.android_record_shop.model;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.example.android_record_shop.service.AlbumApiService;
import com.example.android_record_shop.service.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class AlbumRepository {
    // Declare the following private variables:a MutableLiveData of type List of Album objects an Application
    private ArrayList<Album> albums = new ArrayList<>();
    private MutableLiveData<List<Album>> mutableLiveData;
    private Application application;

    //Create a constructor with just the Application as a parameter
    public AlbumRepository(Application application) {
        this.application = application;
        mutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<Album>> getMutableLiveData() {
        AlbumApiService albumApiService = RetrofitInstance.getService();
        retrofit2.Call<List<Album>> call = albumApiService.getAllAlbums();

        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(retrofit2.Call<List<Album>> call, Response<List<Album>> response) {
               // if (response.isSuccessful() && response.body() != null) {
               Log.i("album List log" , response.message());
                    mutableLiveData.setValue(albums);
                //}
            }
            @Override
            public void onFailure(Call<List<Album>> call, Throwable throwable) {
                // Handle failure case
                Log.i("album List log" , throwable.getMessage());
                throwable.printStackTrace();
            }
        });
        return mutableLiveData;
    }
}
