package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter3 extends RecyclerView.Adapter<RecyclerViewAdapter3.ViewHolder> {

    private List<DataModel3> dataList = new ArrayList<>();

    public void setData(List<DataModel3> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.users3_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataModel3 data = dataList.get(position);
        holder.bind(data);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView idTextView;
        private TextView timeRangeTextView;
        private TextView dateTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idTextView = itemView.findViewById(R.id.id_text_view3);
            timeRangeTextView = itemView.findViewById(R.id.time_range_text_view);
            dateTextView = itemView.findViewById(R.id.date_text_view3);
        }

        public void bind(DataModel3 data) {
            idTextView.setText("ID: " + data.getId());
            dateTextView.setText("Date: " + data.getDate());
            timeRangeTextView.setText("Time Range: " + data.getTimeRange()+"\n\n");
        }
    }
}

