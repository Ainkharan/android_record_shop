package com.example.android_record_shop.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.example.android_record_shop.BR;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Album extends BaseObservable {

    @SerializedName("id")
    @Expose
    Long id;

    @SerializedName("artist")
    @Expose
    String artist;

    @SerializedName("title")
    @Expose
    String title;
    @SerializedName("year")
    @Expose
    int year;
//    @SerializedName("stock")
////    int stock;
//    @SerializedName("genre")
    @Expose
    @SerializedName("genre")
    String genre;

    @SerializedName("label")
    @Expose
    String label;

    public Album(long id, String artist, String title, int year, String genre, String label) {
        this.id = id;
        this.artist = artist;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.label = label;
    }

    public Album() {
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
        return year;
    }

    public void setReleaseYear(int year) {
        this.year = year;
        notifyPropertyChanged(BR.releaseYear);
    }

//    @Bindable
//    public int getStock() {
//        return stock;
//    }
//
//    public void setStock(int stock) {
//        this.stock = stock;
//        notifyPropertyChanged(BR.stock);
//    }

    @Bindable
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
        notifyPropertyChanged(BR.genre);
    }

    @Bindable
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
        notifyPropertyChanged(BR.label);
    }

    @Bindable
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
        notifyPropertyChanged(BR.year);
    }

}
