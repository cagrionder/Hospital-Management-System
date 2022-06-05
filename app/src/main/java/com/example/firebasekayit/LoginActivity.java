package com.example.firebasekayit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

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
        DatabaseReference myRef = database.getReference("Kullanicilar");

        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringTc = tcNo.getText().toString();
                stringSifre = sifre.getText().toString();

                if (!TextUtils.isEmpty(stringTc) && !TextUtils.isEmpty(stringSifre)) {
                    Query sorgu = myRef.orderByChild("tc").equalTo(stringTc);

                    sorgu.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.exists()) {
                                String sifre = snapshot.child(stringTc).child("sifre").getValue(String.class);
                                if (sifre.equals(stringSifre)) {

                                    // BURAYA INTENT YAZILACAK
                                    Intent intent = new Intent(LoginActivity.this, KayitActivity.class);
                                    finish();
                                    startActivity(intent);
                                }
                            } else
                                Toast.makeText(LoginActivity.this, "Böyle Bir Kullanıcı Yok.", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(LoginActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } else
                    Toast.makeText(LoginActivity.this, "Boş alan bırakmayınız lütfen.", Toast.LENGTH_SHORT).show();
            }
        });

        uyeOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LoginActivity.this, KayitActivity.class);
                finish();
                startActivity(intent);
            }
        });

    }
}