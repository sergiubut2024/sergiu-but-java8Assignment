package com.example;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java Main <input file> <target month> <output file>");
            return;
        }

        String inputFile = args[0];
        int targetMonth = Integer.parseInt(args[1]);
        String outputFile = args[2];

        PersonService personService = new PersonService();

        try {
            List<Person> persons = personService.loadPersons(inputFile);
            List<Person> filteredPersons = personService.filterAndSortPersonsByMonth(persons, targetMonth);
            personService.writePersons(filteredPersons, outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
