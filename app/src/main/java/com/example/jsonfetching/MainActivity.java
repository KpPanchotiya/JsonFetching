package com.example.jsonfetching;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.jeson_fetch_tv);
        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMax(30);
        progressDoalog.setMessage("Fetching Data....");
        progressDoalog.setTitle("Holiday Details");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDoalog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (progressDoalog.getProgress() <= progressDoalog
                            .getMax()) {
                        Thread.sleep(60);
                        handle.sendMessage(handle.obtainMessage());
                        if (progressDoalog.getProgress() == progressDoalog
                                .getMax()) {
                            progressDoalog.dismiss();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();


    Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://date.nager.at/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<List<Post>> call =apiInterface.getDetails();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (response.isSuccessful()){
                List<Post> posts =response.body();
                for (Post post:posts) {
                    String abc = "";
                    abc += "Date : " + post.getDate() + "\n";
                    abc += "Local Name : " + post.getLocalName() + "\n";
                    abc += "Name : " + post.getName() + "\n";
                    abc += "Country Code : " + post.getCountryCode() + "\n";
                    abc += "Fixed : " + post.isFixed() + "\n";
                    abc += "Global : " + post.isGlobal() + "\n";
                    abc += "Launch Year : " + post.getLaunchYear() + "\n";
                    abc += "Types : " + post.getTypes() + "\n";
                    abc += "\n\n";
                    textView.append(abc);
                }
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

                textView.setText(t.getMessage());
            }
        });
    }

    Handler handle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            progressDoalog.incrementProgressBy(1);
        }
    };
}