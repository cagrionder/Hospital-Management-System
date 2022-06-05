package com.example.firebasekayit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.adapter_design_backend> {
    List<HospitalModel> dataSet = new ArrayList<>();
    Context context;

    public RecycleAdapter(List<HospitalModel> hospitalModelList, Context context) {
        dataSet = hospitalModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public adapter_design_backend onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_design, parent, false);
        adapter_design_backend design_backend = new adapter_design_backend(view);
        return design_backend;
    }

    @Override
    public void onBindViewHolder(@NonNull adapter_design_backend holder, int position) {
        HospitalModel hospitalModel = dataSet.get(position);
        holder.doctorText.setText(hospitalModel.getDoctorName());
        holder.departmentText.setText(hospitalModel.getDepartmentName());
        holder.hospitalText.setText(hospitalModel.getHospitalName());
        holder.doctorImage.setImageDrawable(hospitalModel.getImageDoctor());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class adapter_design_backend extends RecyclerView.ViewHolder{
        TextView doctorText;
        TextView hospitalText;
        TextView departmentText;
        ImageView doctorImage;
        public adapter_design_backend(@NonNull View itemView) {
            super(itemView);
            doctorText = itemView.findViewById(R.id.doctorText);
            hospitalText = itemView.findViewById(R.id.hospitalText);
            departmentText = itemView.findViewById(R.id.departmentText);
            doctorImage = itemView.findViewById(R.id.imageDoctor);
        }
    }
}
