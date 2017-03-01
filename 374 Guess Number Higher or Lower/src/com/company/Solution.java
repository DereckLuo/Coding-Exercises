package com.company;

/**
 * 374. Guess Number Higher or Lower
 * We are playing the Guess Game. The game is as follows:
 * I pick a number of 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whetehr the number if higher or lower
 * You call a pre-defined API guess(int num) which returns 3 possible results(-1,1,or 0)
 *
 * -1: my number is lower
 *  1: my number is higher
 *  0: Congrats! You got it
 *
 *  Example:
 *  n = 10, I pick 6
 *  Return 6
 * Created by Dereck on 0026, January 26, 2017.
 */
public class Solution {

    private int goal;

    public void setGoal(int input){
        goal = input;
    }

    public int guessNumber(int n ){
        //Simple binary search algorithm
        int low_bound = 1; int high_bound = n;
        int mid = (int)Math.ceil((double)(high_bound - low_bound)/2);
        //System.out.println(mid);
        int guess_result = guess(mid);
        //System.out.println(guess_result);
        while(guess_result != 0){
            if(guess_result == 1){
                low_bound = mid + 1;
            }
            else{
                high_bound = mid - 1;
            }
            mid = low_bound + (high_bound - low_bound)/2;
            //System.out.println(mid);
            guess_result = guess(mid);
        }
        return mid;
    }

    private int guess(int guess){
        if(guess < goal) return 1;
        else if (guess > goal) return -1;
        else return 0;
    }
}
