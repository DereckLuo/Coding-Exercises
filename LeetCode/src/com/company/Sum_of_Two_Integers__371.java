package com.company;

/**
 * 371. Sum of Two Integers
 *      Calculate the sum of two integers a and b, but you are not allowed to use the
 *      operator + and -
 */
public class Sum_of_Two_Integers__371 {
    //using bit manipulation?
    public int getSum(int a, int b){
        return b==0? a:getSum(a^b, (a&b)<<1); //be careful about the terminating condition;
    }
}
