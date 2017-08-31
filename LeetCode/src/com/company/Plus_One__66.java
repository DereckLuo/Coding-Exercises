package com.company;

import java.util.ArrayList;

/**
 * 66. Plus One
 *      Given a non-negative integer represented as a non-empty array of digits,
 *      plus one to the integer.
 *      you may assume the integer do not contain any leading zero, except
 *      the number 0 itself.
 *      The digits are stored such taht the most significant digit is at the head of the list
 *
 */
public class Plus_One__66 {
    public int[] plusOne(int[] digits){
        ArrayList<Integer> arr = new ArrayList<>();
        for(int digit : digits){
            arr.add(digit);
        }
        int carryover = 1;
        for(int i = arr.size()-1; i >= 0; i--){
            int computNumber = arr.get(i) + carryover;
            if(computNumber < 10){
                carryover = 0;
            }
            else{
                carryover = 1;
                computNumber = 10 % computNumber;
            }
            arr.set(i, computNumber);
        }
        arr.add(0, carryover);
        int[] ret = new int[arr.size()];
        for(int i = 0; i < ret.length; i++){
            ret[i] = arr.get(i).intValue();
        }
        return ret;
    }
}
