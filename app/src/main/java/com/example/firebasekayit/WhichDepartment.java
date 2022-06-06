package com.example.firebasekayit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class WhichDepartment extends AppCompatActivity {
    EditText editText;
    Button button;
    String query;
    String[] keys;
    String result;
    EntRegEx entRegEx;
    InternalMedicineRegEx internalMedicineRegEx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_which_department);
        entRegEx = new EntRegEx();
        internalMedicineRegEx = new InternalMedicineRegEx();
        editText = findViewById(R.id.illnessText);
        button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            query = editText.getText().toString();
            keys = query.split(" ");
            entRegEx.calculate(keys);
            internalMedicineRegEx.calculate(keys);
            result = entRegEx.getResult() + internalMedicineRegEx.getResult();
            if(result.equals("")){
                editText.setText("Bulamadık");
            }
            else{
                editText.setText(result);
            }
            result = "";
        });


    }
    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(WhichDepartment.this, MenuActivity.class));
    }
}