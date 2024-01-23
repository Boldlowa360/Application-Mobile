package com.example.activitea;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.Page1)
        {
            Intent i = new Intent(MainActivity.this,MainActivity.class);
            startActivity(i);
            return true;
        }
        if(id == R.id.Page2)
        {
            Intent i = new Intent(MainActivity.this,activity2.class);
            startActivity(i);
            return true;
        }
        if(id == R.id.Page3)
        {
            Intent i = new Intent(MainActivity.this,Activity3.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}