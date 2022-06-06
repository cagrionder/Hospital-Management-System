package com.example.firebasekayit;

import static com.example.firebasekayit.LoginActivity.stringTc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ChangePasswordActivity extends AppCompatActivity {
    EditText editTextFirst;
    EditText editTextConfirm;
    TextView label1;
    TextView label2;
    Button buttonChange;
    String txtFirst, txtConfirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        editTextConfirm = findViewById(R.id.confirmPass);
        editTextFirst = findViewById(R.id.firstPass);
        label1 = findViewById(R.id.textView3);
        label2 = findViewById(R.id.textView4);
        buttonChange = findViewById(R.id.buttonChange);

        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("Kullanicilar");

        buttonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtFirst = editTextFirst.getText().toString().trim();
                txtConfirm = editTextConfirm.getText().toString().trim();
                if (!TextUtils.isEmpty(txtConfirm) && !TextUtils.isEmpty(txtFirst) && txtFirst.equals(txtConfirm)){
                    myRef.child(stringTc).child("sifre").setValue(txtConfirm);
                    editTextFirst.setText("");
                    editTextConfirm.setText("");
                    Toast.makeText(ChangePasswordActivity.this, "Başarılı", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(new Intent(ChangePasswordActivity.this, MenuActivity.class));
                }
                else{
                    Toast.makeText(ChangePasswordActivity.this, "Hatalı Bilgi", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}