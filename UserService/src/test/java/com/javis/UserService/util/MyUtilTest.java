package com.javis.UserService.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MyUtilTest {
    @Mock
    MyUtil myUtil;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        myUtil = new MyUtil();

    }

    @DisplayName("입력한 시간까지 남은 시간")
    @Test
    void test_findXmasEve() {
        //System.out.println(myUtil.howLongRemain(LocalDate.now(),"12","25"));
        System.out.println(myUtil.usedTime("09","30","00","18","00","00"));
    }

}