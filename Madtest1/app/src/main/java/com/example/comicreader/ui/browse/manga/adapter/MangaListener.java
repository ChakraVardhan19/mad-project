package com.example.comicreader.ui.browse.manga.adapter;

import com.example.comicreader.model.Manga;

public interface MangaListener {
    void click(Manga manga);
    void loadMore();
}
