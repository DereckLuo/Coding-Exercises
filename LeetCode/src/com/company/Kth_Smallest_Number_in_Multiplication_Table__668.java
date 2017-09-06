package com.company;

/**
 * Nearly everyone has used the Miltiplication Table. But could you find out
 * the k-th smallest number quickly from the table
 * Given the height m and the length n of a m*n Multiplication table,
 * a positive integer k, need to return the k-th smallest number in table
 *
 * Example 1:
 * Input: m = 3, n = 3, k = 5
 * Multiplication Table is :
 *      1   2   3
 *      2   4   6
 *      3   6   9
 * Output 3
 */
public class Kth_Smallest_Number_in_Multiplication_Table__668 {
    //simply count diagonally to find the kth smallest number
    //set up trackers
    int startTX = 1, startTY = 1, endTX = 1, endTY = 1;
    int startCX = startTX, startCY = startTY, endCX = endTX, endCY = endTY;
    int count = 1;
        while(count < k){
        if(startCX == endCX && startCY == endCY){
            if(startTX < n) startTX += 1;
            else startTY += 1;
            if(endTY < m) endTY += 1;
            else endTX += 1;
            startCX = startTX; startCY = startTY; endCX = endTX; endCY = endTY;
        }
        else{
            if(startCX * startCY < endCX * endCY){
                startCX -= 1; startCY += 1;
            }
            else{
                endCX += 1; endCY -= 1;
            }
        }
        count += 1;
    }
        return Math.min(startCX*startCY, endCX*endCY);
}
