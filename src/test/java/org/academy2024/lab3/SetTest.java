package org.academy2024.lab3;

import com.google.common.collect.Sets;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetTest {

    private record PersonRecord(String name, int age) {
    }

    @Test
    void testSetUniquenessProperty() {

        Set<PersonRecord> persons = new HashSet<>();
        persons.add(new PersonRecord("John", 25));
        persons.add(new PersonRecord("Jane", 30));
        persons.add(new PersonRecord("Doe", 35));

        // Adding a duplicate entry
        persons.add(new PersonRecord("John", 25));

        assertEquals(3, persons.size());
    }

    //TODO replace this implementation with your own, using
    //methods from standard Set interface methods
    //Make copies, as input objects are readonly, and even they are not
    //we should not modify them!
    private <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    @Test
    void testOwnIntersectionImplementation() {

        Set<Integer> set1 = Set.of(1, 2, 3, 4, 5);
        Set<Integer> set2 = Set.of(3, 4, 5, 6, 7);

        assertEquals(Set.of(3, 4, 5), intersection(set1, set2));
    }

}
