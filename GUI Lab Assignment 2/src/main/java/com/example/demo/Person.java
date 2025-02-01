package com.example.demo;

public class Person{
    private String name;
    private String fathername;
    private String cnic;
    private String dob;
    private String gender;
    private String city;

    public Person(String name, String fathername, String cnic, String dob, String gender, String city) {
        this.name = name;
        this.fathername = fathername;
        this.cnic = cnic;
        this.dob = dob;
        this.gender = gender;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", fathername='" + fathername + '\'' +
                ", cnic='" + cnic + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
