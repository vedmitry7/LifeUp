package com.vedmitryapps.lifeup.adapters;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.vedmitryapps.lifeup.fragments.DialogListFragment;
import com.vedmitryapps.lifeup.fragments.ProfileFragment;
import com.vedmitryapps.lifeup.fragments.SimpleFragment;


public class MainPagerAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener {

    private FragmentManager fm;
    TabLayout tabLayout;

    public MainPagerAdapter(FragmentManager fm, TabLayout tabLayout) {
        super(fm);
        this.fm = fm;
        this.tabLayout = tabLayout;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ProfileFragment();
            case 1:
                return new SimpleFragment();
            case 2:
                return new SimpleFragment();
            case 3:
                return new DialogListFragment();
            case 4:
                return new SimpleFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }

    public Fragment getActiveFragment(ViewPager container, int position) {
        String name = makeFragmentName(container.getId(), position);
        return  fm.findFragmentByTag(name);
    }

    private static String makeFragmentName(int viewId, int index) {
        return "android:switcher:" + viewId + ":" + index;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if(tabLayout!=null){
            for (int i = 0; i < 5; i++) {
                if(i == position){
                    tabLayout.getTabAt(i).getIcon().setColorFilter(Color.parseColor("#00dad9"), PorterDuff.Mode.SRC_ATOP);
                    continue;
                }
                tabLayout.getTabAt(i).getIcon().setColorFilter(Color.parseColor("#757575"), PorterDuff.Mode.SRC_ATOP);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}