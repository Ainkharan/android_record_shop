package com.example.android_record_shop;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.android_record_shop.databinding.ActivityMainBinding;
import com.example.android_record_shop.model.Album;
import com.example.android_record_shop.model.Genre;
import com.example.android_record_shop.ui.mainactivity.AlbumAdapter;
import com.example.android_record_shop.ui.mainactivity.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Album> albums;
    private AlbumAdapter albumAdapter;
    private MainActivityViewModel viewModel;
    private ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_main
        );

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        albums = new ArrayList<>();

        getAllAlbums();
    }

    private void getAllAlbums() {

        viewModel.getAllAlbums().observe(this, new Observer<List<Album>>() {
            @Override
            public void onChanged(List<Album> albumsFromLiveData) {

                albums = (ArrayList<Album>) albumsFromLiveData;
                for (Album album: albums) {
                    Log.i("main Activity log", album.toString());
                }

                displayInRecyclerView();
            }
        });
    }

    private void displayInRecyclerView() {

        List<Album> album1 = new ArrayList<>();
        album1.add(new Album(1,"kss","sjsjj",23,43, Genre.ROCK));

        recyclerView = binding.recyclerView;
        albumAdapter = new AlbumAdapter(album1, this);
        recyclerView.setAdapter(albumAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setHasFixedSize(true);
        //binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        albumAdapter.notifyDataSetChanged();
    }
}