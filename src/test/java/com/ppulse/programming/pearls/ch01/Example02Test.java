package com.ppulse.programming.pearls.ch01;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Example02Test {
    private Example02 example02;

    @Before
    public void setup() {
        example02 = new Example02(512);
    }

    @Test
    public void size() {
        Example02 instance01 = new Example02(16);
        assertEquals(64, instance01.size());

        Example02 instance02 = new Example02(32);
        assertEquals(64, instance02.size());

        Example02 instance03 = new Example02(64);
        assertEquals(128, instance03.size());

        Example02 instance04 = new Example02(96);
        assertEquals(128, instance04.size());
    }

    @Test
    public void bitSet() {
        assertFalse(example02.set(65));
        assertTrue(example02.set(65));

        assertTrue(example02.set(65));

        assertFalse(example02.set(122));
        assertTrue(example02.set(122));

        assertFalse(example02.set(67));
        assertTrue(example02.set(67));
    }

    @Test
    public void offset() {
        assertEquals(0, example02.offset(0));
        assertEquals(1, example02.offset(1));
        assertEquals(15, example02.offset(15));
        assertEquals(41, example02.offset(41));
        assertEquals(0, example02.offset(64));
        assertEquals(1, example02.offset(65));
        assertEquals(2, example02.offset(66));
        assertEquals(3, example02.offset(67));
        assertEquals(0, example02.offset(128));
    }

    @Test
    public void bucket() {
        assertEquals(0, example02.bucket(0));
        assertEquals(0, example02.bucket(1));
        assertEquals(0, example02.bucket(15));
        assertEquals(0, example02.bucket(41));
        assertEquals(1, example02.bucket(64));
        assertEquals(1, example02.bucket(65));
        assertEquals(1, example02.bucket(66));
        assertEquals(1, example02.bucket(67));
        assertEquals(2, example02.bucket(128));
        assertEquals(4, example02.bucket(276));
        assertEquals(7, example02.bucket(511));
        assertEquals(8, example02.bucket(512));
        assertEquals(8, example02.bucket(513));
    }

    @Test
    public void bitClear() {
        assertFalse(example02.clear(65));
        assertFalse(example02.set(65));
        assertTrue(example02.clear(65));
        assertFalse(example02.clear(65));

        assertFalse(example02.clear(111));
        assertFalse(example02.set(111));
        assertTrue(example02.clear(111));

        assertFalse(example02.clear(35));
        assertFalse(example02.set(35));
        assertTrue(example02.clear(35));

        assertFalse(example02.clear(256));
        assertFalse(example02.set(256));
        assertTrue(example02.clear(256));
    }

}
