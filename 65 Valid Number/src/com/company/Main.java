package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String input = "2e10";
        Solution sol = new Solution();
        if(sol.isNumber(input)){
            System.out.println("This is a number !");
        }
        else{
            System.out.println("This is NOT a number !");
        }
    }
}
