package com.vedmitryapps.lifeup.adapters;


import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.vedmitryapps.lifeup.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DialogListAdapter extends RecyclerView.Adapter<DialogListAdapter.ViewHolder>{

    Context context;
    int i = 0;
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dialog_list_item, parent, false);
        if(context == null){
           context = parent.getContext();
        }
        return new ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
   //     if (context!=null)
      switch (i){
          case 0:
              holder.icon.setImageDrawable(context.getDrawable(R.drawable.ava));
            break;
            case 1:
              holder.icon.setImageDrawable(context.getDrawable(R.drawable.dibil));
              break;
          case 2:
              holder.icon.setImageDrawable(context.getDrawable(R.drawable.barat));
              break;
          case 3:
              holder.icon.setImageDrawable(context.getDrawable(R.drawable.izv));
              break;
      }
                holder.indicator.setColorFilter(Color.parseColor("#00dad9"), PorterDuff.Mode.SRC_ATOP);
        i++;
        if(i==4)
            i=0;
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
        }
    }
}
