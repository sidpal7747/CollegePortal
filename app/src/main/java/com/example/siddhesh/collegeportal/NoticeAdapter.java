package com.example.siddhesh.collegeportal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by SIDDHESH on 01-01-2017.
 */

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.MyViewHolder> {
    Context context;
    String[] header,detail,time;
    public NoticeAdapter(Context context){
        this.context = context;
        header = context.getResources().getStringArray(R.array.heading);
        detail = context.getResources().getStringArray(R.array.details);
        time = context.getResources().getStringArray(R.array.time);
    }
    @Override
    public NoticeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notice_row, parent, false);
        NoticeAdapter.MyViewHolder vhd = new NoticeAdapter.MyViewHolder(itemView);
        return vhd;
    }

    @Override
    public void onBindViewHolder(NoticeAdapter.MyViewHolder holder, int position) {
        holder.heading.setText(header[position]);
        holder.details.setText(detail[position]);
        holder.time.setText(time[position]);
    }

    @Override
    public int getItemCount() {
        return header.length;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView heading,details,time;

        public MyViewHolder(View view) {
            super(view);
            heading = (TextView)view.findViewById(R.id.heading);
            details = (TextView)view.findViewById(R.id.details);
            time = (TextView)view.findViewById(R.id.time);
        }
    }
}
