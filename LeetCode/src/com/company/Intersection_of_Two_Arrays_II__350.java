package com.company;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 350. Intersection of Two Arrays II
 *      Given two arrays, write a function to compute their intersection.
 *      Example:
 *      Give nums1 = [1,2,2,1], nums2 = [2,2], return [2,2]
 */
public class Intersection_of_Two_Arrays_II__350 {
    public int[] intersect(int[] nums1, int[] nums2){
        ArrayList<Integer> ret = new ArrayList<>();
        HashMap<Integer,Integer> table = new HashMap<>();
        for(int num : nums1){
            if(table.containsKey(num)){
                table.put(num, table.get(num) + 1);
            }
            else{
                table.put(num,1);
            }
        }
        for(int num : nums2){
            if(table.containsKey(num) && table.get(num) != 0){
                ret.add(num);
                table.put(num, table.get(num) - 1);
            }
        }

        int[] outArray = new int[ret.size()];
        for(int i = 0; i < outArray.length; i++){
            outArray[i] = ret.get(i).intValue();
        }
        return outArray;
    }
}
