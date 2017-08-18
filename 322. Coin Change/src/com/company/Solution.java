package com.company;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public int coinChange(int[] coins, int amount){
        if (amount < 1 || coins.length <= 0) return 0;
        return helper(coins, amount, new int[amount]);
    }

    private int helper(int[] coins, int rem, int[] count){
        if(rem < 0) return -1; //not valid
        if(rem == 0) return 0; //compelted
        if(count[rem-1] != 0) return count[rem-1]; //already computed
        int min = Integer.MAX_VALUE;
        for(int coin: coins){
            int res = helper(coins, rem-coin, count);
            if(res >= 0 && res < min){
                min = 1+res;
            }
        }
        count[rem-1] = (min == Integer.MAX_VALUE) ? -1:min;
        return count[rem-1];
    }

    public int coinChangeSol1(int[] coins, int amount){
        int ret = -1;
        if(coins.length == 0) return ret;


        Arrays.sort(coins);
        int minAmount = coins[0];
        reverse(coins);
        HashMap<Integer, Integer> cointable = new HashMap<>();
        for(int num : coins) {
            cointable.put(num, 1);
        }

        ret = coinChangeRec(amount, cointable, minAmount);


        return ret;
    }

    /**
     * Recursive method returns 1 solution but not best solution
     */
    private int coinChangeRec(int amount, HashMap<Integer, Integer> cointable, int minAmount){
       if (changeable(amount, cointable)) return 1;

       int left = minAmount, right = amount-minAmount;
       while(right >= minAmount){
           int left_result = coinChangeRec(left, cointable, minAmount);
           int right_result = coinChangeRec(right, cointable, minAmount);
           if(left_result != -1 && right_result != -1){
               return left_result+right_result;
           }
           left += 1; right -=1;
       }
       return -1;
    }

    private void reverse(int[] coins){
        int start = 0, end = coins.length-1;
        while(start < end){
            int temp = coins[start]; coins[start] = coins[end]; coins[end] = temp;
            start += 1; end -= 1;
        }
        System.out.println("");
    }

    private void printArr(int[] arr){
        for(int num : arr){
            System.out.print(num);
        }
    }

    private boolean changeable(int amount, HashMap<Integer, Integer> table){
        return table.containsKey(amount);
    }
}
