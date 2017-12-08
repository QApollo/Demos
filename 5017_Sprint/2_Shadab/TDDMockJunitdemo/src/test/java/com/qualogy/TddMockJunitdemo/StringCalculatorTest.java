package com.qualogy.TddMockJunitdemo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

//@RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class StringCalculatorTest {

    //@InjectMocks annotation is used to create and inject the mock object
    @InjectMocks
    StringCalculator stringCalculator = new StringCalculator();

    //@Mock annotation is used to create the mock object to be injected
    @Mock
    CalculateService calcService;

   @Test(expected = RuntimeException.class)
    public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
        Mockito.when(calcService.add("10,20,30")).thenThrow(new IllegalArgumentException());
        Assert.assertFalse(stringCalculator.add("10,20,30") > 0);
    }

    @Test
    public final void when2NumbersAreUsedThenNoExceptionIsThrown() {
        Mockito.when(calcService.add("10,20")).thenReturn(30);
        Assert.assertEquals(stringCalculator.add("10,20"),30,0);
    }

    @Test(expected = RuntimeException.class)
    public final void whenNonNumberIsUsedThenExceptionIsThrown() {
       Mockito.when(calcService.add("1,X")).thenThrow(new IllegalArgumentException());
       Assert.assertFalse(stringCalculator.add("1,X") > 0);
    }
}
