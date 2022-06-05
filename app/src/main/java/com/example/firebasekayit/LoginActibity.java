package com.example.firebasekayit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class LoginActibity extends AppCompatActivity {

    ImageView img;
    EditText tcNo, sifre;
    Button kaydet, uyeOl;
    String stringTc, stringSifre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        img = findViewById(R.id.imageView);
        img.setBackgroundResource(R.drawable.clinic);
        tcNo = findViewById(R.id.editTextTextTcNo);
        sifre = findViewById(R.id.editTextSifree);
        kaydet = findViewById(R.id.button);
        uyeOl = findViewById(R.id.button3);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringTc = tcNo.getText().toString();
                stringSifre = sifre.getText().toString();

            }
        });

        uyeOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LoginActibity.this, KayitActivity.class);
                finish();
                startActivity(intent);
            }
        });
    }
}