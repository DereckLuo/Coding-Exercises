package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    /**
     *  Java binary search solution
     */
    public int findRadius(int[] houses, int[] heaters){
        Arrays.sort(heaters);
        int ret = Integer.MIN_VALUE;

        for(int house: houses){
            int idx = Arrays.binarySearch(heaters, house);
            System.out.println(idx);
            if(idx < 0) idx = -(idx+1);
//            System.out.println(idx);
            int left_dist = idx - 1 >= 0? house-heaters[idx-1]:Integer.MAX_VALUE;
            int right_dist = idx < heaters.length ? heaters[idx] - house: Integer.MAX_VALUE;
            ret = Math.max(ret, Math.min(left_dist, right_dist));
        }
        return ret;
    }

    public int findRadiusTimeout(int[] houses, int[] heaters){
        HashMap<Integer, Integer> houseset = new HashMap<>();
        HashMap<Integer, Integer> heaterset = new HashMap<>();
        for(int house: houses) houseset.put(house, 1);
        for(int heater: heaters) heaterset.put(heater, 1);

//        System.out.println("check point");
        int radius = -1;
        int cp1 = 0, cp2 = 0;
        while(!houseset.isEmpty()){
            radius +=1;
//            System.out.println(radius);
            for(int heater: heaterset.keySet()){
//                System.out.println(heater);
                ArrayList<Integer> remove = new ArrayList<>();
                for(int house: houseset.keySet()){
//                    System.out.println(house);
                    if(Math.abs(heater-house) <= radius){
//                        System.out.println("cp2");
                        remove.add(house);
                    }
                }
                System.out.println(remove);
                for(int house: remove) houseset.remove(house);
            }

        }
        return radius;
    }
}
