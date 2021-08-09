package com.javis.UserService.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class ObjectArrayTest {
    @Mock
    ObjectArray objectArray;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        objectArray = new ObjectArray();
    }

    @Test
    void test_createCart() {
        Product[] arr = objectArray.createCart();
//        for(Product i: arr){
//            System.out.println(i.toString());
//        }
        assertEquals("Coffee", arr[0].getDescription());

    }
}