package com.vedmitryapps.lifeup.adapters;


import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.vedmitryapps.lifeup.R;
import com.vedmitryapps.lifeup.activities.DialogActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DialogAdapter extends RecyclerView.Adapter<DialogAdapter.ViewHolder>{

    Context context;
    int i = 0;
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dialog_message_item, parent, false);
        if(context == null){
           context = parent.getContext();
        }
        return new ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageView)
        ImageView icon;
        @BindView(R.id.messageIndicator)
        ImageView indicator;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DialogActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }
}
