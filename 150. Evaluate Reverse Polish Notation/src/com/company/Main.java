package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] input = new String[]{"2","1","+","3","*"};

        Solution sol = new Solution();

        int value = sol.evalRPN(input);
        System.out.println("Final evaluation value is : ");
        System.out.println(value);
    }
}
