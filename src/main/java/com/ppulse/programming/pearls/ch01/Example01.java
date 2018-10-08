package com.ppulse.programming.pearls.ch01;

import java.util.Arrays;

/**
 * 习题1、如果不缺内存如何使用一个具有库的语言来实现一种排序算法以表示和排序集合
 * <p>
 * 不缺内存时，使用库函数来排序
 */
public class Example01 {
    public int[] sort(int[] input) {
        int[] output = Arrays.copyOf(input, input.length);
        Arrays.sort(output);
        return output;
    }
}
