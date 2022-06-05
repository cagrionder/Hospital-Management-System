package com.example.firebasekayit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class KayitActivity extends AppCompatActivity {

    EditText kayitTc, kayitAd, kayitSoyad, dt, kayitTel, kayitMail, kayitAdres, kayitSifre;
    String txtTc, txtAd, txtSoyad, txtDt, txtTel, txtMail, txtAdres, txtSifre, txtCinsiyet;
    Calendar cal;
    Button geri, kayit;
    RadioButton kadin, erkek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();

        dt = findViewById(R.id.editTextTarih);
        geri = findViewById(R.id.buttonGeri);
        kayit = findViewById(R.id.buttonKayit);
        kayitTc = findViewById(R.id.editTextTc);
        kayitAd = findViewById(R.id.editTextAd);
        kayitSoyad = findViewById(R.id.editTextSoyad);
        kayitTel = findViewById(R.id.editTextTel);
        kayitMail = findViewById(R.id.editTextMail);
        kayitAdres = findViewById(R.id.editTextAdres);
        kayitSifre = findViewById(R.id.editTextSifre);
        kadin = findViewById(R.id.radioKadin);
        erkek = findViewById(R.id.radioErkek);


        cal = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int yil, int ay, int gun) {
                cal.set(Calendar.YEAR, yil);
                cal.set(Calendar.MONTH, ay);
                cal.set(Calendar.DAY_OF_MONTH, gun);

                updateCalender();

            }

            private void updateCalender() {
                String Format = "dd/MM/yyy";
                SimpleDateFormat sdf = new SimpleDateFormat(Format, Locale.getDefault());

                dt.setText(sdf.format(cal.getTime()));
            }

        };

        dt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog = new DatePickerDialog(KayitActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, date, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KayitActivity.this, MainActivity.class);
                finish();
                startActivity(intent);
            }
        });

        kayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtTc = kayitTc.getText().toString().trim();
                txtAd = kayitAd.getText().toString().trim();
                txtSoyad = kayitSoyad.getText().toString().trim();
                if (kadin.isChecked())
                    txtCinsiyet = kadin.getText().toString().trim();
                if (erkek.isChecked())
                    txtCinsiyet = erkek.getText().toString().trim();
                txtDt = dt.getText().toString().trim();
                txtTel = kayitTel.getText().toString().trim();
                txtMail = kayitMail.getText().toString().trim();
                txtAdres = kayitAdres.getText().toString().trim();
                txtSifre = kayitSifre.getText().toString().trim();
                if (!TextUtils.isEmpty(txtTc) && !TextUtils.isEmpty(txtAd) && !TextUtils.isEmpty(txtSoyad) && !TextUtils.isEmpty(txtCinsiyet) && !TextUtils.isEmpty(txtDt) && !TextUtils.isEmpty(txtTel) && !TextUtils.isEmpty(txtMail) && !TextUtils.isEmpty(txtAdres) && !TextUtils.isEmpty(txtSifre)) {
                    myRef.child("Kullanicilar").child(txtTc).setValue(new User(txtAd, txtSoyad, txtCinsiyet, txtDt, txtTel, txtMail, txtAdres, txtSifre));
                    kayitTc.setText("");
                    kayitAd.setText("");
                    kayitSoyad.setText("");
                    kadin.setChecked(false);
                    erkek.setChecked(false);
                    dt.setText("");
                    kayitTel.setText("");
                    kayitMail.setText("");
                    kayitAdres.setText("");
                    kayitSifre.setText("");
                }
                else
                    Toast.makeText(KayitActivity.this, "Boş alan bırakmayınız lütfen.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(KayitActivity.this, MainActivity.class);
        finish();
        startActivity(intent);
    }
}