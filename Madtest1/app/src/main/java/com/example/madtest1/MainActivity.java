package com.example.madtest1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();  // this removes top bar with named application title
        actionBar.hide();
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.page_1);
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.page_1:
                        return true;
                    case R.id.page_2:
                        startActivity(new Intent(getApplicationContext(),history.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.page_3:
                        Toast.makeText(MainActivity.this, "brow", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.page_4:
                        Toast.makeText(MainActivity.this, "settings", Toast.LENGTH_SHORT).show();
                        break;

                }
                return true;
            }
        });

        }

}


