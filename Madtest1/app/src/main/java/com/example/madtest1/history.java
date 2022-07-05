package com.example.madtest1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.ActionBar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class history extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ActionBar actionBar = getSupportActionBar();  // this removes top bar with named application title
        actionBar.hide();
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.page_1:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        Toast.makeText(history.this, "lib", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.page_2:
                        startActivity(new Intent(getApplicationContext(),history.class));
                        Toast.makeText(history.this, "his", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.page_3:
                        Toast.makeText(history.this, "brow", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.page_4:
                        Toast.makeText(history.this, "settings", Toast.LENGTH_SHORT).show();
                        break;

                }
                return true;
            }
        });
    }
}