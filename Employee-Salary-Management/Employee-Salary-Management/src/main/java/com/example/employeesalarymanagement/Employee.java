package com.example.employeesalarymanagement;

import java.io.Serializable;

public class Employee implements Serializable {
    int id;
    String name;
    String age;
    String gender;
    String department;
    double baseSalary;
    int hoursWorked;
    String performanceRating;
    double totalSalary;

    public Employee(int id, String name, String age, String gender, String department, double baseSalary, int hoursWorked, String performanceRating, double totalSalary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.baseSalary = baseSalary;
        this.hoursWorked = hoursWorked;
        this.performanceRating = performanceRating;
        this.totalSalary = calculateTotalSalary();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public String getPerformanceRating() {
        return performanceRating;
    }

    public void setPerformanceRating(String performanceRating) {
        this.performanceRating = performanceRating;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public double calculateTotalSalary() {
        double performanceBonus = 0;
        double overtimeBonus = 0;

        if(hoursWorked>160){
            overtimeBonus = (hoursWorked-160)* 200;
        }

        switch (performanceRating) {
            case "Excellent":
                performanceBonus = baseSalary * 0.20;
                break;
                case "Good":
                    performanceBonus = baseSalary * 0.15;
                    break;
                case "Average":
                    performanceBonus = baseSalary * 0.05;
                    break;

            case "Poor":
                performanceBonus = 0;

        }

        return baseSalary + overtimeBonus + performanceBonus;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", baseSalary=" + baseSalary +
                ", hoursWorked=" + hoursWorked +
                ", performanceRating='" + performanceRating + '\'' +
                ", totalSalary=" + totalSalary +
                '}';

    }
}
