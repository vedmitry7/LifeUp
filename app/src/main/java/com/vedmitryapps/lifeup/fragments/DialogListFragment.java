package com.vedmitryapps.lifeup.fragments;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SearchView;

import com.vedmitryapps.lifeup.R;
import com.vedmitryapps.lifeup.adapters.DialogListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DialogListFragment extends Fragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.toolbarContainer)
    RelativeLayout container;
    @BindView(R.id.burger_button)
    ImageButton button;

    @BindView(R.id.simpleSearchView)
    SearchView searchView;

    DialogListAdapter dialogListAdapter;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pager_diallogs, container, false);
        ButterKnife.bind(this, view);

        //container.setPadding(0, getStatusBarHeight(),0,0);
       // container.setPaddingRelative(0,getStatusBarHeight(),0,0);
        dialogListAdapter = new DialogListAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(dialogListAdapter);


        button.setColorFilter(Color.parseColor("#00dad9"), PorterDuff.Mode.SRC_ATOP);

        ImageView icon = searchView.findViewById(android.support.v7.appcompat.R.id.search_mag_icon);

        Log.i("TAG21", String.valueOf(icon==null));

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
