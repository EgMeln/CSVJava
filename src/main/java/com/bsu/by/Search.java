package com.bsu.by;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Search {
    static List<Company> findByShortName(List<Company> companyList, String shortName) {
        List<Company> result = new ArrayList<>();
        for (Company company : companyList) {
            if (company.getShortName().equalsIgnoreCase(shortName)) {
                result.add(company);
            }
        }
        return result;
    }

    static List<Company> findByIndustry(List<Company> companyList, String industry) {
        List<Company> result = new ArrayList<>();
        for (Company company : companyList) {
            if (company.getIndustry().equalsIgnoreCase(industry)) {
                result.add(company);
            }
        }
        return result;
    }

    static List<Company> findByActivity(List<Company> companyList, String activity) {
        List<Company> result = new ArrayList<>();
        for (Company company : companyList) {
            if (company.getActivity().equalsIgnoreCase(activity)) {
                result.add(company);
            }
        }
        return result;
    }

    static List<Company> findByFoundationDate(List<Company> companyList, Date firstDate, Date secondDate) {
        List<Company> result = new ArrayList<>();
        for (Company company : companyList) {
            if (company.getFoundDate().compareTo(firstDate) >= 0 && company.getFoundDate().compareTo(secondDate) <= 0) {
                result.add(company);
            }
        }
        return result;
    }

    static List<Company> findByAmountEmployee(List<Company> companyList, int firstNumber, int secondNumber) {
        List<Company> result = new ArrayList<>();
        for (Company company : companyList) {
            if (company.getAmountEmployee() >= firstNumber && company.getAmountEmployee() <= secondNumber) {
                result.add(company);
            }
        }
        return result;
    }
}
