package com.example.android_record_shop.ui.mainactivity;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.android_record_shop.model.Album;
import com.example.android_record_shop.model.AlbumRepository;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    /*
    Declare a new AlbumRepository variable in this class and hover over the red error line under the class declaration
    and create the constructor. This constructor needs to assign this.albumRepository variable to a new AlbumRepository()
    and pass in application as the argument
     */
    AlbumRepository albumRepository;

    public MainActivityViewModel(@NotNull Application application) {
        super(application);
        this.albumRepository = new AlbumRepository(application);
    }

    public LiveData<List<Album>> getAllAlbums() {
        return albumRepository.getMutableLiveData();
    }
}
