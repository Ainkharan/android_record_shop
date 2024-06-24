package com.example.android_record_shop.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.example.android_record_shop.BR;

public class Album extends BaseObservable {

    //@SerializedName("id")
    long id;
    //@SerializedName("artist")
    String artist;
    // @SerializedName("title")
    String title;
    //@SerializedName("releaseYear")
    int releaseYear;
    //@SerializedName("stock")
    int stock;
    //@SerializedName("genre")
    Genre genre;

    public Album() {
    }

    public Album(long id, String artist, String title, int releaseYear, int stock, Genre genre) {
        this.id = id;
        this.artist = artist;
        this.title = title;
        this.releaseYear = releaseYear;
        this.stock = stock;
        this.genre = genre;
    }

    @Bindable
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
        notifyPropertyChanged(BR.artist);
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
        notifyPropertyChanged(BR.releaseYear);
    }

    @Bindable
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
        notifyPropertyChanged(BR.stock);
    }

    @Bindable
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
        notifyPropertyChanged(BR.genre);
    }
}
