package com.vedmitryapps.lifeup.adapters;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.vedmitryapps.lifeup.fragments.ProfileInfoFragment;
import com.vedmitryapps.lifeup.fragments.SimpleFragment;


public class ProfilePagerAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener {

    private FragmentManager fm;
    TabLayout tabLayout;

    public ProfilePagerAdapter(FragmentManager fm, TabLayout tabLayout) {
        super(fm);
        this.fm = fm;
        this.tabLayout = tabLayout;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ProfileInfoFragment();
            case 1:
                return new SimpleFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
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
            for (int i = 0; i < 2; i++) {
                if(i == position){
                   // tabLayout.getTabAt(i).getIcon().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);
               //     tabLayout.getTabAt(i).getCustomView().setBackgroundColor(Color.WHITE);
                //    tabLayout.getChildAt(i).setBackgroundColor(Color.WHITE);

                    continue;
                }
               // tabLayout.getTabAt(i).getIcon().setColorFilter(Color.parseColor("#757575"), PorterDuff.Mode.SRC_ATOP);
              //  tabLayout.getTabAt(i).getCustomView().setBackgroundColor(Color.BLACK);
              //  tabLayout.getChildAt(i).setBackgroundColor(Color.BLACK);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Личная информация";
            case 1:
                return "Новости";
        }
        return null;
    }
}