package com.bsu.by;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.Date;

public class Company {
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private String name;
    private String shortName;
    private Date actualData;
    private String address;
    private Date foundDate;
    private int amountEmployee;
    private String auditor;
    private String number;
    private String email;
    private String industry;
    private String activity;
    private String internetAddress;
    private String[] str;

    public Company(String name, String shortName, Date actualData, String address, Date foundDate, int amountEmployee,
                   String auditor, String number, String email, String industry, String activity, String internetAddress) {
        this.name = name;
        this.shortName = shortName;
        this.actualData = actualData;
        this.address = address;
        this.foundDate = foundDate;
        this.amountEmployee = amountEmployee;
        this.auditor = auditor;
        this.number = number;
        this.email = email;
        this.industry = industry;
        this.activity = activity;
        this.internetAddress = internetAddress;
    }

    Company(String[] str) throws IOException, ParseException {
        if (str.length != 12) {
            throw new IllegalArgumentException("Error: wrong number of fields");
        }
        this.str = str;
        this.name = str[0];
        this.shortName = str[1];
        this.actualData = dateFormat.parse(str[2]);
        this.address = str[3];
        this.foundDate = dateFormat.parse(str[4]);
        this.amountEmployee = Integer.parseInt(str[5]);
        this.auditor = str[6];
        this.number = str[7];
        this.email = str[8];
        this.industry = str[9];
        this.activity = str[10];
        this.internetAddress = str[11];
    }

    public String getShortName() {
        return shortName;
    }

    public String getIndustry() {
        return industry;
    }

    public String getActivity() {
        return activity;
    }

    public Date getFoundDate() {
        return foundDate;
    }

    public int getAmountEmployee() {
        return amountEmployee;
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
