package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Intent3 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter3 adapter;
    private RetrofitInterface retrofitInterface;

    private TextView textViewActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent3);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter3();
        recyclerView.setAdapter(adapter);

        textViewActivity = findViewById(R.id.textViewActivity);

        retrofitInterface = RetrofitClient.getRetrofitInstance().create(RetrofitInterface.class);

        fetchUserData();
        fetchLatestPredictedActivity();
    }

    private void fetchUserData() {
        Call<List<DataModel3>> call = retrofitInterface.getUsers3();
        call.enqueue(new Callback<List<DataModel3>>() {
            @Override
            public void onResponse(Call<List<DataModel3>> call, Response<List<DataModel3>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<DataModel3> userList = response.body();
                    adapter.setData(userList);
                }
            }

            @Override
            public void onFailure(Call<List<DataModel3>> call, Throwable t) {
                Log.d("TAG", "onFailure: " + t.getMessage());
            }
        });
    }

    private void fetchLatestPredictedActivity() {
        Call<ActivityResponse> call = retrofitInterface.getLatestPredictedActivity();
        call.enqueue(new Callback<ActivityResponse>() {
            @Override
            public void onResponse(Call<ActivityResponse> call, Response<ActivityResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    String latestActivity = response.body().getLatestPredictedActivity();
                    String formattedActivity = "현재상태: " + latestActivity;
                    textViewActivity.setText(formattedActivity);
                } else {
                    Log.d("TAG", "Failed to retrieve activity");
                }
            }

            @Override
            public void onFailure(Call<ActivityResponse> call, Throwable t) {
                Log.d("TAG", "Error: " + t.getMessage());
            }
        });
    }
}
