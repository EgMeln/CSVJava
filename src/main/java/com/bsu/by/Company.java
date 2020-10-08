package com.bsu.by;

import java.io.IOException;

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

    Company(String[] str) throws IOException {
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

    String[] getStr() {
        return str;
    }
}
