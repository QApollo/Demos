package com.qualogy.demo;

import junit.framework.TestCase;

public class AppSumTest extends TestCase {

    public void testSum() {
        assertEquals(new App().sum(1, 1), 2);
    }

}