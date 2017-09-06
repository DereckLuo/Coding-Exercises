package com.company;

import java.util.*;

/**
 * 15 3Sum
 *      Given an array S of n integers, are three elements a,b,c in S such that
 *      a + b + c = 0? Find all unique triples in the array which sum of zero
 *
 *  Example:
 *      Array S = [-1,0,1,2,-1,4]
 *      Solution set:
 *      [[-1,0,1], [-1,-1,2]]
 */
public class ThreeSum__15 {
    /**
     * The idea is to sort an input array and then run through all indices of
     * a possible first element of a triplet. For each possible first element
     * we make a standard bi-directional 2Sum sweep of the remaining part of
     * the array. Also we want to skip equal elements to avoid duplicates in
     * the answer without making a set or smth like that.
     */
    public List<List<Integer>> threeSum(int[] num){
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> brutforce(int[] nums){
        HashMap<String, Integer> table = new HashMap<>();
        List<List<Integer>> ret = new ArrayList<>();
        for(int i = 0; i < nums.length-2; i++){
            for(int j = i+1; j < nums.length-1; j++){
                for(int k = j+1; k < nums.length; k++){
                    if(nums[i]+nums[j]+nums[k] == 0){
                        int[] temp = new int[]{nums[i], nums[j], nums[k]};
                        Arrays.sort(temp);
                        String key = Integer.toString(temp[0]) + Integer.toString(temp[1]) + Integer.toString(temp[2]);
                        if(!table.containsKey(key)){
                            table.put(key, 1);
                            List<Integer> line = new ArrayList<>();
                            line.add(temp[0]); line.add(temp[1]); line.add(temp[2]);
                            ret.add(line);

                        }
                    }
                }
            }
        }
        return ret;
    }
}
