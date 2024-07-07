package com.example;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonServiceTest {

    @Test
    public void testFilterAndSortPersonsByMonth() {
        PersonService personService = new PersonService();

        List<Person> persons = Arrays.asList(
            new Person("John", "Doe", LocalDate.of(1990, 5, 15)),
            new Person("Jane", "Smith", LocalDate.of(1991, 5, 20)),
            new Person("Alice", "Johnson", LocalDate.of(1992, 6, 10)),
            new Person("Bob", "Brown", LocalDate.of(1989, 5, 25))
        );

        List<Person> filteredPersons = personService.filterAndSortPersonsByMonth(persons, 5);
        assertEquals(3, filteredPersons.size());
        assertEquals("Bob", filteredPersons.get(0).getFirstName());
        assertEquals("Jane", filteredPersons.get(1).getFirstName());
        assertEquals("John", filteredPersons.get(2).getFirstName());
    }
}
