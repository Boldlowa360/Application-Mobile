package com.example.activitea;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
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
            Intent i = new Intent(Activity3.this,MainActivity.class);
            startActivity(i);
            return true;
        }
        if(id == R.id.Page2)
        {
            Intent i = new Intent(Activity3.this,activity2.class);
            startActivity(i);
            return true;
        }
        if(id == R.id.Page3)
        {
            Intent i = new Intent(Activity3.this,Activity3.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
