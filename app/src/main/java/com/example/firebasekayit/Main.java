package com.example.firebasekayit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity {
    RecyclerView recyclerView;
    RecycleAdapter adapter;
    List<HospitalModel> hospitalModelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);
        hospitalModelList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        String aaa = null;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<HospitalModel> options =
                new FirebaseRecyclerOptions.Builder<HospitalModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Dataset"), HospitalModel.class)
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