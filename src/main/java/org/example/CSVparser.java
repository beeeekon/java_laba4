package org.example;

import java.io.*;
import java.nio.file.FileSystemNotFoundException;
import java.util.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;

import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.commons.io.FilenameUtils;

import static java.io.File.separator;
import static java.lang.System.in;

public class CSVparser {

    private String filepath;

    private boolean correct_input_filepath(String path) {
        File file = new File(path);
        if (file.exists() && FilenameUtils.getExtension(path).equals("csv")) {
            filepath = path;
            return true;
        }
        return false;
    }

    private String check_input() {
        Scanner in = new Scanner(System.in);
        String path = "";
        System.out.println("Enter the file path: ");
        if (in.hasNextLine())
            path = in.nextLine();
        while (!correct_input_filepath(path)) {
            System.out.println("Invalid input. Enter the file path again:");
            if (in.hasNextLine())
                path = in.nextLine();
        }
        return path;
    }

    public List<Person> fileRead() throws IOException, CsvValidationException {
        int num;
        List<Person> prsn = new ArrayList();

        //if (correct_input_filepath(check_input())) {
        System.out.println("Enter the file path: ");
        Scanner in = new Scanner(System.in);
        String path=in.nextLine();;
        filepath = path;
            InputStream file = CSVparser.class.getClassLoader().getResourceAsStream(filepath);
            CSVReader reader = file ==null ? null: new CSVReaderBuilder(new InputStreamReader(file))
                    .withCSVParser(new CSVParserBuilder().withSeparator(';').build()).build();
            if (reader==null){
                throw new FileSystemNotFoundException(filepath);
            }
            String[] nextStr;

            while ((nextStr = reader.readNext()) != null) {
                Random rndm = new Random();
                num = rndm.nextInt(25000);
                prsn.add(new Person(nextStr[0], nextStr[1], nextStr[2], nextStr[5], nextStr[3], nextStr[4], num));
            }
       // }
        return prsn;
    }


}