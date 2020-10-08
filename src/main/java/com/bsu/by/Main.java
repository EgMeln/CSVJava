package com.bsu.by;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Company> companyList = new ArrayList<>();
        readUsingScanner("InputText.txt", companyList);
        writeStringToFile("OutputText.txt", companyList);

    }

    private static ArrayList<Company> readUsingScanner(String filename, ArrayList<Company> companyList) throws IOException {
        Path path = Paths.get(filename);
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] company = line.split(";");
                companyList.add(new Company(company));
            }
            return companyList;
        } catch (IOException a) {
            System.out.println(a.getMessage());
        }
        return null;
    }

    public static void writeStringToFile(String fileName, ArrayList<Company> companyList) throws IOException {
        try (FileWriter fw = new FileWriter(fileName, false)) {
            for (Company i : companyList) {
                for (String j : i.getStr()) {
                    fw.write(j + ";");
                }
                fw.write("\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
