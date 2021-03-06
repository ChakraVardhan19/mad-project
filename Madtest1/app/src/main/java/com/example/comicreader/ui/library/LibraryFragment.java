package com.example.comicreader.ui.library;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.comicreader.MTConstants;
import com.example.comicreader.R;
import com.example.comicreader.database.MangaDatabase;
import com.example.comicreader.model.Manga;
import com.example.comicreader.ui.browse.BrowsePagerAdapter;
import com.example.comicreader.ui.detail.MangaDetails;
import com.example.comicreader.ui.library.manga.adapter.MangaAdapter;
import com.example.comicreader.ui.library.manga.adapter.MangaListener;
import com.example.comicreader.ui.library.manga.option.OptionSheet;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class LibraryFragment extends Fragment {

    public LibraryFragment() {
    }

    public static LibraryFragment newInstance() {
        return new LibraryFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_library, container, false);

        LibraryPagerAdapter pagerAdapter = new LibraryPagerAdapter(getChildFragmentManager());

        ViewPager viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter(pagerAdapter);

        TabLayout tabs = view.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        return view;
    }
}