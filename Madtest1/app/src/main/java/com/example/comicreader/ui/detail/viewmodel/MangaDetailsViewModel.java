package com.example.comicreader.ui.detail.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.comicreader.model.Chapter;
import com.example.comicreader.model.Manga;
import com.example.comicreader.networking.readm.RClient;

import java.util.List;

public class MangaDetailsViewModel extends ViewModel {
    MutableLiveData<List<Chapter>> chapters = new MutableLiveData<>();
    MutableLiveData<Manga> detail = new MutableLiveData<>();

    public MutableLiveData<List<Chapter>> chapters(Manga manga){
        RClient.chapters(chapters, manga);
        return chapters;
    }

    public MutableLiveData<Manga> detail(Manga manga){
        RClient.details(detail, manga);
        return detail;
    }
}
