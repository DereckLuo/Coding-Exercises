package com.company;

/**
 * 514. Freedom Trail:
 * In the video game Fallout 4, bla bla bla
 *
 * Given a string ring, which represents the code engraved on the outer ring and another string key
 * which represents the keyword needs to be spelled. You need to find the minimum number of steps
 * in order to spell all the characters in the keyword
 *
 * Initially, the first character of the ring is aligned at 12:00 direction. Need to spell all char
 * in the key one by one by rotating ring clockwise or anticlockwise to make each char of the key
 * aligned at 12:00 direction
 *
 */
public class Freedom_Trail__514 {
    public int findRotateSteps(String ring, String key){
        int rl = ring.length();
        int kl = key.length();
        int[][] table = new int[kl+1][rl];

        for(int i = kl-1; i >= 0; i--){
            for(int j = 0; j < rl; j++){
                table[i][j] = Integer.MAX_VALUE;
                for(int k = 0; k < rl; k++){
                    if(ring.charAt(k) == key.charAt(i)){
                        int diff = Math.abs(j-k);
                        int step = Math.min(diff, rl-diff);
                        table[i][j] = Math.min(table[i][j], step + table[i+1][k]);
                    }
                }
            }
        }
        return table[0][0] + kl;
    }
}
