package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int input = 10;
        Solution sol = new Solution();
        sol.setGoal(input);
        int output = sol.guessNumber(10);
        System.out.println("The number is : " + Integer.toString(output));
    }
}
