package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Intent4 extends AppCompatActivity {
    EditText checkEditText;
    EditText dayEditText;
    EditText dateEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent4);

        checkEditText = findViewById(R.id.checkEditText);
        dayEditText = findViewById(R.id.dayEditText);
        dateEditText = findViewById(R.id.dateEditText);

        Button sendButton = findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EditText에서 사용자 입력 가져오기
                String check = checkEditText.getText().toString();
                String day = dayEditText.getText().toString();
                String date = dateEditText.getText().toString();

                // User 객체 생성
                DataModel user = new DataModel(check, day, date);

                // Retrofit을 사용하여 서버로 데이터 전송
                RetrofitInterface apiService = RetrofitClient.getRetrofitInstance().create(RetrofitInterface.class);
                Call<Void> call = apiService.createUser(user);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.isSuccessful()) {
                            // 서버로의 전송이 성공한 경우 처리
                            Toast.makeText(Intent4.this, "Data sent successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            // 서버로의 전송이 실패한 경우 처리
                            String errorMessage = "Failed to send data: " + response.message();
                            Toast.makeText(Intent4.this, errorMessage, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        // 통신 실패 시 처리
                        String errorMessage;
                        if (t != null && t.getMessage() != null) {
                            errorMessage = "Failed to send data to server: " + t.getMessage();
                        } else {
                            errorMessage = "Failed to send data to server: Unknown error";
                        }
                        Toast.makeText(Intent4.this, errorMessage, Toast.LENGTH_SHORT).show();
                    }

                });
            }
        });
    }
}
