package com.vedmitryapps.lifeup.fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
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
    @BindView(R.id.profileInfoContainer)
    ConstraintLayout profileInfoContainer;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pager_profile, container, false);
        ButterKnife.bind(this, view);

        ProfilePagerAdapter pagerAdapter = new ProfilePagerAdapter(getChildFragmentManager(), tabLayout);
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        profileInfoContainer.setPadding(0,getStatusBarHeight(),0,0);
       // profileInfoContainer.setPaddingRelative(0,getStatusBarHeight(),0,0);

        return view;
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
