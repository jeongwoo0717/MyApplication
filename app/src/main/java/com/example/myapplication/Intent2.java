package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Intent2 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter2 adapter;
    private RetrofitInterface retrofitInterface;

    private Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent2);

        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent_4 = new Intent(Intent2.this,Intent4.class);
                startActivity(Intent_4);
            }
        });

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter2();
        recyclerView.setAdapter(adapter);

        retrofitInterface = RetrofitClient.getRetrofitInstance().create(RetrofitInterface.class);
        Call<List<DataModel2>> call = retrofitInterface.getUsers2();
        call.enqueue(new Callback<List<DataModel2>>() {
            @Override
            public void onResponse(Call<List<DataModel2>> call, Response<List<DataModel2>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<DataModel2> userList = response.body();
                    adapter.setData(userList);
                }
            }

            @Override
            public void onFailure(Call<List<DataModel2>> call, Throwable t) {
                Log.d("TAG", "onFailure: " + t.getMessage());
            }
        });
    }
}