package com.company;

/**
 * 191. Number of 1 Bits
 *      Write a function that takes an unsigned integer and returns the number of
 *      '1' bits it has (Hamming weight)
 *
 *      For example, the 32-bit integer '11' returns 3
 */
public class Number_of_1_Bits__191 {
    public int hammingWeight(int n){
        return Integer.bitCount(n);
    }
}
