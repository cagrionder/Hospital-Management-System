package com.example.firebasekayit;
import android.graphics.drawable.Drawable;

public class HospitalModel {
    String doctorName;
    String imageDoctor;
    String hospitalName;
    String departmentName;
    //bla bla


    public HospitalModel() {

    }

    public HospitalModel(String doctorName, String hospitalName, String departmentName, String img) {
        this.doctorName = doctorName;
        this.hospitalName = hospitalName;
        this.departmentName = departmentName;
        this.imageDoctor = img;
    }

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

    public String getImageDoctor() {
        return imageDoctor;
    }

    public void setImageDoctor(String imageDoctor) {
        this.imageDoctor = imageDoctor;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }
}
