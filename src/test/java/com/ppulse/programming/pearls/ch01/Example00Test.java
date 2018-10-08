package com.ppulse.programming.pearls.ch01;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Example00Test {
    private Example00 example00;

    @Before
    public void setup() {
        example00 = new Example00();
    }

    @Test
    public void sort() {
        int[] expected = {1, 3, 4, 6, 7, 9};
        int[] input = {7, 3, 4, 9, 1, 6};
        assertArrayEquals(expected, example00.sort(input));
    }

}