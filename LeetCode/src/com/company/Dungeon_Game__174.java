package com.company;

/**
 * 174. Dungeon Game
 *      The demons had captured the princess(P) and imprisoned her in the bottom-right corner of
 *      a dungeon. The dungeon consists of M X N rooms laid out in a 2D grid. Our valiant knight(K)
 *      was initially positioned in the top-left room and must fight his way through the dungeon
 *
 *      The knight has an initial health point represented by a positive int. if at any point
 *      his health point drops to 0 or below, he dies
 *
 *      Sme of the rooms are guarded by demons so knight loses health; other rooms are either empty
 *      or contain magic orbs increase knight's health
 *
 *      In order to reach princess as quickly as possible, the knight decides to move only right
 *      or down in each step
 *
 *      Write a function to determine the knight's minimum initial health so that he is able
 *      to rescue the princess
 *
 *      In another word -- find lowest cost to the target
 */
public class Dungeon_Game__174 {
    public int calculateMinimumHP(int[][] dungeon) {
        // printDungeon(dungeon);
        // System.out.println("");
        for(int i = dungeon.length-1; i >= 0; i--){
            for(int j = dungeon[i].length-1; j >= 0; j--){
                int cur_val = dungeon[i][j];
                //corner case
                if(i == dungeon.length - 1 && j == dungeon[i].length-1){
                    dungeon[i][j] = dungeon[i][j] >= 0 ? 1 : (-dungeon[i][j] + 1);
                }
                else{
                    int goRight = Integer.MAX_VALUE, goDown = Integer.MAX_VALUE;
                    if(j < dungeon[i].length-1){    //check right
                        if(cur_val >= 0){
                            goRight = cur_val >= dungeon[i][j+1] ? 1 : dungeon[i][j+1] - dungeon[i][j];
                        }
                        else{
                            goRight = dungeon[i][j+1] - dungeon[i][j];
                        }
                    }
                    if(i < dungeon.length-1){   //check down
                        if(cur_val >= 0){
                            goDown = cur_val >= dungeon[i+1][j] ? 1: dungeon[i+1][j] - dungeon[i][j];
                        }
                        else{
                            goDown = dungeon[i+1][j] - dungeon[i][j];
                        }
                    }
                    // System.out.println(Integer.toString(goRight) + ", " + Integer.toString(goDown));
                    dungeon[i][j] = Math.min(goRight, goDown);
                }
            }
        }
        // printDungeon(dungeon);
        return dungeon[0][0];
    }

    private void printDungeon(int[][] d){
        System.out.println("");
        for(int i = 0; i < d.length; i++){
            for(int j = 0; j < d[i].length; j++){
                System.out.print(d[i][j]); System.out.print(" ");
            }
            System.out.println("");
        }
    }

    +
}
