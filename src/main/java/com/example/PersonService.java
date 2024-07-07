package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PersonService {

    public List<Person> loadPersons(String filename) throws IOException {
        return Files.lines(Paths.get(filename))
                .map(line -> {
                    String[] parts = line.split(",");
                    return new Person(parts[0].trim(), parts[1].trim(), LocalDate.parse(parts[2].trim()));
                })
                .collect(Collectors.toList());
    }

    public List<Person> filterAndSortPersonsByMonth(List<Person> persons, int month) {
        return persons.stream()
                .filter(person -> person.getDateOfBirth().getMonthValue() == month)
                .sorted((p1, p2) -> p1.getFirstName().compareToIgnoreCase(p2.getFirstName()))
                .collect(Collectors.toList());
    }

    public void writePersons(List<Person> persons, String filename) throws IOException {
        List<String> lines = persons.stream()
                .map(person -> person.getFirstName() + ", " + person.getLastName())
                .collect(Collectors.toList());
        Files.write(Paths.get(filename), lines);
    }
}
