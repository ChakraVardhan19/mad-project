package com.example.comicreader.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.comicreader.ui.browse.BrowseFragment;
import com.example.comicreader.ui.library.LibraryFragment;
import com.example.comicreader.ui.search.SearchFragment;
import com.example.comicreader.ui.setting.SettingFragment;

import java.util.ArrayList;
import java.util.List;

public class MainPagerAdapter extends FragmentStatePagerAdapter  {
    List<Fragment> fragments = new ArrayList<>();

    public MainPagerAdapter(FragmentManager fm) {
        super(fm, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        setFragments();
    }

    public void setFragments() {
        fragments.add(LibraryFragment.newInstance());
        fragments.add(BrowseFragment.newInstance());
        fragments.add(SearchFragment.newInstance());
        fragments.add(SettingFragment.newInstance());
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
