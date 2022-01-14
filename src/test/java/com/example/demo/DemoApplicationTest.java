package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DemoApplicationTest {

    Calculator underTest = new Calculator();

    @Test //Junit-Jupiter
    void itShouldAddNumbers(){

        //BDD test style .. given, when, then
        //given
        int num1 = 20;
        int num2 = 30;
        int expected = 50;

        //when
        var result = underTest.add(num1, num2);

        //then, ... assert
        //Asserts from AssertJ, not JUnit
        assertThat(result).isEqualTo(expected);
    }

    class Calculator{
        int add(int a, int b){
            return a + b;
        }
    }
}
