package com.example.firebasekayit;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class RecycleAdapter extends FirebaseRecyclerAdapter<HospitalModel, RecycleAdapter.myViewHolder> {


    public RecycleAdapter(@NonNull FirebaseRecyclerOptions<HospitalModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull HospitalModel model) {

        holder.txtDoctor.setText(model.getDoctorName());
        holder.txtDepartment.setText(model.departmentName);
        holder.txtHospital.setText(model.hospitalName);

        Glide.with(holder.img.getContext())
                .load(model.getImageDoctor())
                .placeholder(R.mipmap.ic_launcher_round)
                .centerCrop()
                .error(R.mipmap.ic_launcher_round)
                .into(holder.img);
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_design, parent, false);

        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView txtDoctor, txtHospital, txtDepartment;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.imageDoctor);
            txtDoctor = itemView.findViewById(R.id.doctorText);
            txtHospital = itemView.findViewById(R.id.hospitalText);
            txtDepartment = itemView.findViewById(R.id.departmentText);

        }
    }

}
