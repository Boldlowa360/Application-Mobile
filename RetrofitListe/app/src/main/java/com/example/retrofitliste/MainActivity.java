package com.example.retrofitliste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.retrofitliste.http.RetrofitUtil;
import com.example.retrofitliste.http.Service;
import com.example.retrofitliste.transfert.Truc;

import java.time.LocalDateTime;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TrucAdapter trucAdapter;
    Adapter adapter;

    final Service service = RetrofitUtil.get();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initLongRecycler();
        this.remplirLongRecycler();
        this.initTrucRecycler();
        this.remplirTrucRecycler();
    }

    private void initTrucRecycler(){
        RecyclerView recyclerView = findViewById(R.id.recycler1);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        trucAdapter = new TrucAdapter();
        recyclerView.setAdapter(trucAdapter);
    }
    private void initLongRecycler(){
        RecyclerView recyclerView = findViewById(R.id.recycler2);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new Adapter();
        recyclerView.setAdapter(adapter);
    }
    private void remplirTrucRecycler() {
        service.listeTrucs().enqueue(new Callback<List<Truc>>() {
            @Override
            public void onResponse(Call<List<Truc>> call, Response<List<Truc>> response) {
             if(response.isSuccessful()){
                 trucAdapter.list.addAll(response.body());
                 trucAdapter.notifyDataSetChanged();
             }else{
                 Log.i("RETROFIT", response.code()+"");
             }
            }
            @Override
            public void onFailure(Call<List<Truc>> call, Throwable t) {
                Log.i("RETROFIT", t.getMessage());
            }
        });
    }

    private void remplirLongRecycler() {
        service.listeLong().enqueue(new Callback<List<Long>>() {
            @Override
            public void onResponse(Call<List<Long>> call, Response<List<Long>> response) {
                if(response.isSuccessful()){
                    adapter.list.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }else{
                    Log.i("RETROFIT", response.code()+"");
                }
            }
            @Override
            public void onFailure(Call<List<Long>> call, Throwable t) {
                Log.i("RETROFIT", t.getMessage());
            }
        });
    }
}