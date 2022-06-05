package com.example.firebasekayit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    EditText tcNo, sifre;
    Button kaydet, uyeOl;
    String stringTc, stringSifre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

                Intent intent = new Intent(MainActivity.this, KayitActivity.class);
                finish();
                startActivity(intent);
            }
        });




    }
}