package com.vedmitryapps.lifeup.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vedmitryapps.lifeup.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DialogListFragment extends Fragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    DialogListAdapter dialogListAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diallog, container, false);
        ButterKnife.bind(this, view);

        recyclerView.setPadding(0,0,0,0);
        dialogListAdapter = new DialogListAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(dialogListAdapter);

        return view;
    }
}
