package com.example.firebasekayit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

import java.net.InetSocketAddress;

public class MenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ImageView kardiyoloji, dahiliye;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    String kardText = "kard";
    String dahiText = "dahi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        kardiyoloji = findViewById(R.id.imageKardi);
        dahiliye = findViewById(R.id.imageDahiliye);

        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        kardiyoloji.setOnClickListener(view ->{
            Intent intentMainK = new Intent(MenuActivity.this, Main.class);
            intentMainK.putExtra("keyName", kardText);
            startActivity(intentMainK);
            //no no ??veri göndermeli put extra fln o mu
        });
        dahiliye.setOnClickListener(view ->{
            Intent intentMainD = new Intent(MenuActivity.this, Main.class);
            intentMainD.putExtra("keyName", dahiText);
            startActivity(intentMainD);
        });

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.nav_bolum:
                startActivity(new Intent(MenuActivity.this, WhichDepartment.class));
                break;
            case R.id.nav_exit:
                finish();
                break;
            case R.id.nav_change:
                System.out.println("aaasasas");
                startActivity(new Intent(MenuActivity.this, ChangePasswordActivity.class));

        }

        return true;
    }
}