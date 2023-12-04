package com.example.springtest.SpyTest;

import com.example.springtest.mockTest.Person;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class SimpleSpyTest {

    @Test
    public void spyTest() {
        Person spyPerson = spy(Person.class);
        Person person = new Person();

        when(spyPerson.getAge()).thenReturn(20);

        System.out.println(spyPerson.getAge());
        System.out.println(spyPerson.getName());
        System.out.println(person.getAge());
        System.out.println(person.getName());
    }
}
