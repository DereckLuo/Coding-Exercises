package com.company;

public class Main {
    /**
     * 292. Nim Game
     * You are playing the following Nim Game with your friend: There is a heap of
     * stones on the table, each time one of you take turns to remove 1 to 3 stones.
     * The one who removes the last stone will be the winner. You will take the
     * first tun to remove the stones
     * Both of you are very clever and have optimal strategies for the game.
     * Write a function to determine whether you can win the game given the number
     * of stones in the heap
     *
     * Game Theory : Perfect game
     */
    public static void main(String[] args) {
	// write your code here
        int input = 105;
        Solution sol = new Solution();

        boolean output = sol.canWinNim(input);

        System.out.println(output);
    }
}
