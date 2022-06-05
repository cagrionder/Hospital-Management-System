package com.example.firebasekayit;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity {
    RecyclerView recyclerView;
    RecycleAdapter adapter;
    String keyDepartment;
    List<HospitalModel> hospitalModelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);
        keyDepartment = getIntent().getStringExtra("keyName");
        hospitalModelList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<HospitalModel> options =
                new FirebaseRecyclerOptions.Builder<HospitalModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Dataset").orderByChild("departmentName").equalTo(keyDepartment), HospitalModel.class)
                        .build();
        adapter = new RecycleAdapter(options);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }


}