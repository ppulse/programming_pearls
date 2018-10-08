package com.ppulse.programming.pearls.ch01;

/**
 * 位运算
 *             384|383          320|319          256|255          128|127        64|63                      |0
 * ...1010_10...10_10101010_10...10_10101010_10...10_10101010_10...10_10101010_10...10_10101010_..1010.._10101010
 */
public class Example02 {
    private long[] bitset;
    private static final int BIT_NUM_OF_TWO = 6;
    private static final int BIT_NUM_OF_LONG = 1 << BIT_NUM_OF_TWO;
    private static final int MASK = BIT_NUM_OF_LONG - 1;


    public Example02() {
        this(64);
    }

    public Example02(int bitNum) {
        bitset = new long[(bitNum >>> BIT_NUM_OF_TWO) + 1];
    }

    public int size() {
        return bitset.length << BIT_NUM_OF_TWO;
    }

    public boolean set(int index) {
        boolean old = test(index);
        bitset[bucket(index)] |= (1 << offset(index));
        return old;
    }

    public boolean clear(int index) {
        boolean old = test(index);
        bitset[bucket(index)] &= ~(1 << offset(index));
        return old;
    }

    int offset(int index) {
        return index & MASK;
    }

    int bucket(int index) {
        return index >>> BIT_NUM_OF_TWO;
    }

    boolean test(int index) {
        return (bitset[bucket(index)] & (1 << offset(index))) != 0;
    }
}
