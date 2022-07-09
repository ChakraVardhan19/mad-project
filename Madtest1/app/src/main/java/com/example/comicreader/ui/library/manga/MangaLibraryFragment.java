package com.example.comicreader.ui.library.manga;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.comicreader.MTConstants;
import com.example.comicreader.R;
import com.example.comicreader.database.MangaDatabase;
import com.example.comicreader.model.Manga;
import com.example.comicreader.ui.detail.MangaDetails;
import com.example.comicreader.ui.library.manga.adapter.MangaAdapter;
import com.example.comicreader.ui.library.manga.adapter.MangaListener;
import com.example.comicreader.ui.library.manga.option.OptionSheet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MangaLibraryFragment extends Fragment implements MangaListener {

    private final List<Manga> mangaList = new ArrayList<>();
    private MangaAdapter adapter;
    private MangaDatabase database;
    private TextView oops;
    private TextView oopsText;

    public MangaLibraryFragment() {
    }

    public static MangaLibraryFragment newInstance() {
        return new MangaLibraryFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_manga_library, container, false);
        database = MangaDatabase.getDatabase(requireContext());

        ProgressBar progressBar = view.findViewById(R.id.progress_bar);
        oops = view.findViewById(R.id.oops);
        oopsText = view.findViewById(R.id.oops_text);

        RecyclerView mangaLayout = view.findViewById(R.id.manga_layout);
        mangaLayout.setLayoutManager(new GridLayoutManager(requireContext(), 3));
        adapter = new MangaAdapter(this, mangaList);
        mangaLayout.setAdapter(adapter);

        database.mangaDao().all().observe(requireActivity(), mangas -> {

            if (mangas.size() == 0) {
                oops.setText(MTConstants.OOPS[new Random().nextInt(MTConstants.OOPS.length)]);
                oopsText.setText(R.string.oops_text);
                visibility(View.VISIBLE);
            } else {
                visibility(View.GONE);
            }

            mangaList.clear();
            mangaList.addAll(mangas);
            adapter.notifyDataSetChanged();
            progressBar.setVisibility(View.GONE);
        });

        return view;
    }

    public void visibility(int mode) {
        oopsText.setVisibility(mode);
        oops.setVisibility(mode);
    }

    @Override
    public void click(Manga manga) {
        startActivity(new Intent(requireActivity(), MangaDetails.class)
                .putExtra("manga", manga)
                .putExtra("page", "lib"));
    }

    @Override
    public void remove(Manga manga) {
        OptionSheet sheet = new OptionSheet(requireContext(), database, manga);
        sheet.show();
    }
}