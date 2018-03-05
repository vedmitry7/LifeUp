package com.vedmitryapps.lifeup.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vedmitryapps.lifeup.R;
import com.vedmitryapps.lifeup.adapters.ProfilePagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ProfileFragment extends Fragment {


    @BindView(R.id.profileViewPager)
    ViewPager viewPager;

    @BindView(R.id.profileTabs)
    TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment, container, false);
        ButterKnife.bind(this, view);

        ProfilePagerAdapter pagerAdapter = new ProfilePagerAdapter(getChildFragmentManager(), tabLayout);
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }
}
