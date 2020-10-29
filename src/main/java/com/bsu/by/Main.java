package com.bsu.by;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    public static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static final String LOG_FILE_NAME = "logfile.txt";

    public static void main(String[] args) throws IOException {
        ArrayList<Company> companyList = new ArrayList<>();
        Path path = Paths.get("InputText.txt");
        FileWriter fw = new FileWriter("OutputText.txt", false);
        Scanner inputRequest = new Scanner(new FileReader("inRequest.txt"));
        LOGGER.setLevel(Level.FINE);
        FileHandler fh = new FileHandler(LOG_FILE_NAME, true);
        fh.setLevel(Level.FINE);
        fh.setFormatter(new SimpleFormatter());
        LOGGER.addHandler(fh);
        LOGGER.fine("Program started...\n");
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] company = line.split(";");
                companyList.add(new Company(company));
            }
            int index = 1;
            //List<Company> foundCompanies = getByRequest(companyList);
            String request;
            while (inputRequest.hasNextLine()) {
                request = inputRequest.nextLine();
                getByRequestSQL(request, companyList, index);
                index++;
            }
//            for (Company i : foundCompanies) {
//                for (String j : i.getStr()) {
//                    fw.write(j + ";");
//                }
//                fw.write("\n");
//            }
        } catch (IOException | ParseException a) {
            System.out.println(a.getMessage());
        }
        fw.close();
    }

    public static void showRequest() {
        System.out.println("1.by short name");
        System.out.println("2.by department of work");
        System.out.println("3.by activity kind");
        System.out.println("4.by foundation date (between DATE1 && DATE2) [dd.MM.yyyy]");
        System.out.println("5.by employees number (between NUM1 && NUM2)");
        System.out.println();
    }

    static List<Company> getByRequest(List<Company> companyList) throws IllegalArgumentException, ParseException {
        List<Company> result = new ArrayList<>();
        String requestString;
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                showRequest();
                System.out.println("Enter request: ");
                switch (sc.nextInt()) {
                    case 1:
                        System.out.println("Enter shortname: ");
                        String shortName = sc.next();
                        requestString = shortName;
                        result = Search.findByShortName(companyList, shortName);
                        break;
                    case 2:
                        System.out.println("Enter industry");
                        String industry = sc.next();
                        requestString = industry;
                        result = Search.findByIndustry(companyList, industry);
                        break;
                    case 3:
                        System.out.println("Enter kind of activity: ");
                        String activity = sc.next();
                        requestString = activity;
                        result = Search.findByActivity(companyList, activity);
                        break;
                    case 4:
                        System.out.println("Enter first dates: ");
                        requestString = sc.next();
                        Date firstDate = Company.dateFormat.parse(requestString);
                        System.out.println("Enter second dates: ");
                        requestString = sc.next();
                        Date secondDate = Company.dateFormat.parse(requestString);
                        result = Search.findByFoundationDate(companyList, firstDate, secondDate);
                        break;
                    case 5:
                        System.out.println("Enter first numbers: ");
                        requestString = sc.next();
                        int firstNumber = Integer.parseInt(requestString);
                        System.out.println("Enter second dates: ");
                        requestString = sc.next();
                        int secondNumber = Integer.parseInt(requestString);
                        result = Search.findByAmountEmployee(companyList, firstNumber, secondNumber);
                        break;
                    default:
                        return result;
                }
                Main.LOGGER.fine("Find company " + " :" + requestString + ", Companies found: " + result.size() + "\n");
            }
        }
    }

    static void getByRequestSQL(String str, List<Company> companyList, int index) throws ParseException {
        String[] data = str.toLowerCase().split(" |\\=");
        List<Company> result = new ArrayList<>();
        for (int i = 5; i < data.length; i++) {
            switch (data[i]) {
                case "short_name":
                    result = Search.findByShortName(companyList, data[i + 1]);
                    break;
                case "industry":
                    result = Search.findByIndustry(companyList, data[i + 1]);
                    break;
                case "employee":
                    int num1 = Integer.parseInt(data[i + 2]);
                    int num2 = Integer.parseInt(data[i + 4]);
                    i += 2;
                    result = Search.findByAmountEmployee(companyList, num1, num2);
                    break;
            }
        }
        try (FileWriter of = new FileWriter(new File("Request" + index + ".csv"))) {
            if (result.isEmpty()) {
                of.write("None\n");
            } else {
                for (Company company : result) {
                    of.write(company.toString() + System.lineSeparator());
                }
            }
            of.write(System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.fine("SQL request: " + str + "\nCompanies found: " + result.size());
    }
}

