package com.gsa.consume.microservices.model;

import java.io.Serializable;

public class Employee implements Serializable {

    private String employeeID;
    private String employeeName;
    private Float salary;
    private String designation;
    private String reporttingManager;

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getReporttingManager() {
        return reporttingManager;
    }

    public void setReporttingManager(String reporttingManager) {
        this.reporttingManager = reporttingManager;
    }
}
