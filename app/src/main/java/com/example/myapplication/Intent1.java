package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Intent1 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter1 adapter;
    private RetrofitInterface retrofitInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent1);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter1();
        recyclerView.setAdapter(adapter);

        retrofitInterface = RetrofitClient.getRetrofitInstance().create(RetrofitInterface.class);
        Call<List<DataModel1>> call = retrofitInterface.getUsers1();
        call.enqueue(new Callback<List<DataModel1>>() {
            @Override
            public void onResponse(Call<List<DataModel1>> call, Response<List<DataModel1>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<DataModel1> userList = response.body();
                    adapter.setData(userList);
                }
            }

            @Override
            public void onFailure(Call<List<DataModel1>> call, Throwable t) {
                Log.d("TAG", "onFailure: " + t.getMessage());
            }
        });
    }
}