package com.example.android_record_shop.model;

import android.app.Application;
import android.util.JsonReader;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.example.android_record_shop.service.AlbumApiService;
import com.example.android_record_shop.service.RetrofitInstance;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AlbumRepository {
    // Declare the following private variables:a MutableLiveData of type List of Album objects an Application
    private ArrayList<Album> albums = new ArrayList<>();
    private MutableLiveData<List<Album>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    //Create a constructor with just the Application as a parameter
    public AlbumRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Album>> getMutableLiveData() {
        AlbumApiService albumApiService = RetrofitInstance.getService();
        Call<ResponseBody> call = albumApiService.getRawJson();

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseBody> call, Response<ResponseBody> response) {
                Gson gson = new Gson();
                Type listType = new TypeToken<ArrayList<Album>>(){}.getType();
                ArrayList<Album> list = gson.fromJson(response.body().charStream(), listType);
                mutableLiveData.setValue(list);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                // Handle failure case
                Log.i("album List log", throwable.getMessage());
                throwable.printStackTrace();
            }
        });
        return mutableLiveData;
    }
}
