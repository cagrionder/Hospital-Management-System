package com.example.firebasekayit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import static com.example.firebasekayit.LoginActivity.stringTc;

import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.net.InetSocketAddress;

public class MenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ImageView kardiyoloji, dahiliye;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    String kardText = "kard";
    String dahiText = "dahi";
    DatabaseReference myRef;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        builder = new AlertDialog.Builder(MenuActivity.this);
        myRef = FirebaseDatabase.getInstance().getReference("Kullanicilar");
        builder.setTitle("Hesap Silinmesi");
        builder.setMessage("Emin misiniz?");
        builder.setNegativeButton("Hayır", null);
        builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                myRef.child(stringTc).removeValue();
                Toast.makeText(MenuActivity.this, "Başarıyla silindi", Toast.LENGTH_SHORT).show();
                finish();
                System.exit(0);
            }
        });
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

        kardiyoloji.setOnClickListener(view -> {
            Intent intentMainK = new Intent(MenuActivity.this, Main.class);
            intentMainK.putExtra("keyName", kardText);
            startActivity(intentMainK);
            //no no ??veri göndermeli put extra fln o mu
        });
        dahiliye.setOnClickListener(view -> {
            Intent intentMainD = new Intent(MenuActivity.this, Main.class);
            intentMainD.putExtra("keyName", dahiText);
            startActivity(intentMainD);
        });

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_bolum:
                startActivity(new Intent(MenuActivity.this, WhichDepartment.class));
                break;
            case R.id.nav_exit:
                finish();
                System.exit(0);
                break;
            case R.id.nav_change:
                startActivity(new Intent(MenuActivity.this, ChangePasswordActivity.class));
                break;
            case R.id.nav_delete:
                builder.show();
                break;
        }

        return true;
    }
}