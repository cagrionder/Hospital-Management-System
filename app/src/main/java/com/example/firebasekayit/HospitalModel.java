package com.example.firebasekayit;
import android.graphics.drawable.Drawable;

public class HospitalModel {
    String doctorName;
    Drawable imageDoctor;
    String hospitalName;
    String departmentName;
    //bla bla

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Drawable getImageDoctor() {
        return imageDoctor;
    }

    public void setImageDoctor(Drawable imageDoctor) {
        this.imageDoctor = imageDoctor;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }
}
