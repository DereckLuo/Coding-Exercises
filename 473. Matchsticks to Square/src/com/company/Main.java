package com.company;

public class Main {
    /**
     * 473. Matchsticks to Square
     *  Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little
     *  girl has, please find out a way you can make one square by using up all those matchsticks.
     *  You should not break any stick, but you can link them up, and each matchstick must be used
     *  exactly one time.
     *
     *  Your input will be several matchsticks the girl has, represented with their stick length.
     *  Your output will either be true or false, to represent whether you could make one square using
     *  all the matchsticks
     *
     *  Example:
     *  Input : [1,1,2,2,2]
     *  Output: true
     *  Input: [3,3,3,3,4]
     *  Output: false
     *
     */
    public static void main(String[] args) {
	// write your code here
        int[] input = {1,1,2,2,2};
        Solution sol = new Solution();

        boolean output = sol.makesquare(input);

        if (output)
            System.out.println("True");
        else
            System.out.println("False");
    }
}

