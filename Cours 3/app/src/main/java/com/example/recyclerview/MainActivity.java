package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    SecretAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initRecycler();
        this.remplirRecycler();
    }

    private void remplirRecycler() {
        for(int i = 0; i <1000;i++){
            Secret s = new Secret();
            s.nom="Objet "+i;
            s.date= LocalDateTime.now();
            s.nbGrand = Long.valueOf(i);
            adapter.list.add(s);
        }
    }

    private void initRecycler(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new SecretAdapter();
        recyclerView.setAdapter(adapter);
    }
}