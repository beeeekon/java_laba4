package org.example;

import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.*;


public class Main {
    /**
     * main метод
     * @param args аргументы main
     * @throws IOException проблемы с input/output
     */
    public static  void main(String[] args) throws IOException, CsvValidationException {
        List<Person> prsn;
        String exit_code;
        CSVparser reader = new CSVparser();
        Scanner in = new Scanner(System.in);
        do {
            prsn = reader.fileRead();

            for (int i = 1; i < prsn.size(); i++)
                System.out.println(prsn.get(i));
            System.out.println("Enter 'mur' to exit.");
            exit_code = in.nextLine();
        } while (!Objects.equals(exit_code, "mur"));
    }
}