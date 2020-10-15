package com.bsu.by;

import java.io.IOException;
import java.util.Objects;

public class Company {
    private String name;
    private String shortName;
    private String actualData;
    private String address;
    private String foundDate;
    private String amountEmployee;
    private String auditor;
    private String number;
    private String email;
    private String industry;
    private String activity;
    private String internetAddress;
    private String[] str;

    public Company(String name, String shortName, String actualData, String address, String foundDate, String amountEmployee,
                   String auditor, String number, String email, String industry, String activity, String internetAddress){
        this.name = name;
        this.shortName = shortName;
        this.actualData = actualData;
        this.address = address;
        this.foundDate = foundDate;
        this.amountEmployee = amountEmployee;
        this.auditor = auditor;
        this.number= number;
        this.email = email;
        this.industry = industry;
        this.activity = activity;
        this.internetAddress = internetAddress;
    }

    Company(String[] str) throws IOException {
        if (str.length != 12) {
            throw new IllegalArgumentException("Error: wrong number of fields");
        }
        this.str = str;
        this.name = str[0];
        this.shortName = str[1];
        this.actualData = str[2];
        this.address = str[3];
        this.foundDate = str[4];
        this.amountEmployee = str[5];
        this.auditor = str[6];
        this.number = str[7];
        this.email = str[8];
        this.industry = str[9];
        this.activity = str[10];
        this.internetAddress = str[11];
    }

    public String[] getStr() {
        return str;
    }

    public int hashCode() {
        return Objects.hash(name, shortName, actualData, address, foundDate, amountEmployee, auditor, number, email, industry, activity, internetAddress);
    }

    public String toString() {
        return name + ";" + shortName + ";" + actualData + ";" + address + ";" + foundDate + ";" + amountEmployee + ";"
                + auditor + ";" + number + ";" + email + ";" + industry + ";" + activity + ";" + internetAddress + ";";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name) && Objects.equals(shortName, company.shortName) && Objects.equals(actualData, company.actualData) &&
                Objects.equals(address, company.address) && Objects.equals(foundDate, company.foundDate) && Objects.equals(amountEmployee, company.amountEmployee) &&
                Objects.equals(auditor, company.auditor) && Objects.equals(number, company.number) && Objects.equals(email, company.email) && Objects.equals(industry, company.industry) &&
                Objects.equals(activity, company.activity) && Objects.equals(internetAddress, company.internetAddress);
    }
}
