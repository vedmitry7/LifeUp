package com.vedmitryapps.lifeup.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.vedmitryapps.lifeup.R;
import com.vedmitryapps.lifeup.adapters.DialogAdapter;

import butterknife.BindView;

public class DialogActivity extends AppCompatActivity {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    DialogAdapter dialogAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        dialogAdapter = new DialogAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(dialogAdapter);
    }
}
