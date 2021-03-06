package com.javis.UserService.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.test.context.EmbeddedKafka;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ArrayDemoTest {
    @Mock
    ArrayDemo arrayDemo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        arrayDemo = new ArrayDemo();
    }

    @Test
    void test_fill() {
        String s = "";
        int[] arr = arrayDemo.fill(7);
        for(int i: arr){
            s += i;
        }
        assertEquals("77777", s);
    }

    @Test
    void test_copy() {
        String s = "";
        int[] arr = arrayDemo.copy(new int[]{7,7,7,7,7},0,2,2);
        for(int i: arr){
            s += i;
        }
        assertEquals("00770", s);
    }
    @Test
    void test_createIntegerArray(){
        String s = "";
        int[] arr = arrayDemo.createIntegerArray(1, 6);
        for(int i : arr){
            //System.out.println(i);
            s += i;
        }
        assertEquals("12345",s);
    }
}