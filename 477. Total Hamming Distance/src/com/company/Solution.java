package com.company;

import java.util.HashMap;

public class Solution {

    public int totalHammingDistance(int[] nums){
        if (nums.length <= 1){
            return 0;
        }

        int ret = 0;
        HashMap<String, Integer> table = new HashMap<>();
        for(int i = 0; i < nums.length-1; i++){
            for(int j = 1; j < nums.length; j++){
                int intOne = nums[i];
                int intTwo = nums[j];
                String key = Integer.toString(Math.min(intOne,intTwo)) +
                        "," + Integer.toString(Math.max(intOne, intTwo));

                if(table.containsKey(key)){
                    ret += table.get(key);
                }
                else{
                    int distance = HammingDistance(intOne, intTwo);
                    ret += distance;
                    table.put(key, distance);
                }
            }
        }
        return ret;
    }

    public int HammingDistance(int a, int b){
        return Integer.bitCount(a ^ b);
    }

    /**
     * O(n) time solution
     */
    public int totalHamingDistanceOn(int[] nums){
        int total = 0, n = nums.length;
        for(int j = 0; j < 32; j++){
            int bitCount = 0;
            for(int i = 0; i < n; i++){
                bitCount += (nums[i] >> j) & 1;
            }
            total += bitCount*(n-bitCount);
        }
        return total;
    }
}
