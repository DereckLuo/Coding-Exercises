package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here]
        int[] input = new int[]{1,2,3,4,5,2,4,5,1};
        int distance = 12;

        Solution sol = new Solution();
        if(sol.containsNearbyDuplicate(input, distance)){
            System.out.println("There is nearby duplicates");
        }
        else{
            System.out.println("There is NO nearby duplicates");
        }
    }
}
