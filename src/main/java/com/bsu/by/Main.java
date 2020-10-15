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
        Path path = Paths.get("InputText.txt");
        FileWriter fw = new FileWriter("OutputText.txt", false);
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] company = line.split(";");
                companyList.add(new Company(company));
            }
            for (Company i : companyList) {
                for (String j : i.getStr()) {
                    fw.write(j + ";");
                }
                fw.write("\n");
            }
        } catch (IOException a) {
            System.out.println(a.getMessage());
        }
        fw.close();
    }
}
