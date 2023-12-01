package com.example.springtest.mockTest;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SimpleMockTest {

    @Test
    public void mockTest() {
        Person mockPerson = mock(Person.class);
        Person person = new Person();
        when(mockPerson.getAge()).thenReturn(20);  // stubbing

        System.out.println(mockPerson.getAge());
        System.out.println(mockPerson.getName());
        System.out.println(person.getAge());
        System.out.println(person.getName());
    }

}
