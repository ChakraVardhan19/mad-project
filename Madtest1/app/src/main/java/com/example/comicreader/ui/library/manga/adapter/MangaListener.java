package com.example.comicreader.ui.library.manga.adapter;

import com.example.comicreader.model.Manga;

public interface MangaListener {
    void click(Manga manga);
    void remove(Manga manga);
}
