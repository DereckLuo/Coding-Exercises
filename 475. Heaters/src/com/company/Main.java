package com.company;

public class Main {

    /**
     * 475. Heaters
     *  Winter is coming! your first job during the contest is to design a standard
     *  heater with fixed warm radius to warm all the houses
     *  Now, you are given positions of houses and heaters on a horizontal line, find out
     *  minimum radius of heaters so that all houses could be covered by those heaters
     *  So your input will be the positions of houses and heaters separately, and your
     *  expected output will be the minimum radius standard of heaters
     *  Example 1:
     *  Input: [1,2,3],[2]
     *  output: 1
     */
    public static void main(String[] args) {
	// write your code here
        int[] house = {1,2,3,10,11,12};
        int[] heater = {4,11};

        Solution sol = new Solution();

        int output = sol.findRadius(house, heater);

        System.out.println(output);
    }
}
