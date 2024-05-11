package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
public class RecyclerViewAdapter1 extends RecyclerView.Adapter<RecyclerViewAdapter1.ViewHolder> {

    private List<DataModel1> dataList = new ArrayList<>();

    public void setData(List<DataModel1> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.users1_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataModel1 data = dataList.get(position);
        holder.bind(data);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView idTextView;
        private TextView checkTextView;
        private TextView dayTextView;
        private TextView dateTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idTextView = itemView.findViewById(R.id.id_text_view1);
            dateTextView = itemView.findViewById(R.id.date_text_view1);
            dayTextView = itemView.findViewById(R.id.day_text_view1);
            checkTextView = itemView.findViewById(R.id.check_text_view1);
        }

        public void bind(DataModel1 data) {
            idTextView.setText("ID: " + data.getId());
            dateTextView.setText("Date: " + data.getDate());
            dayTextView.setText("Day: " + data.getDay());
            checkTextView.setText("Check: " + data.getCheck()+"\n\n");
        }
    }
}
