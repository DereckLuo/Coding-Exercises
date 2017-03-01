package com.company;

/**
 * Created by Dereck on 0023, February 23, 2017.
 */
public class MaxLake {

    static int getMaxLakeVolume(int[] heights, int[] distances) {
        int ret = 0; //size of max lake, start as 0

        for(int i = 0; i < heights.length-1; i++){  //possible left side
            int left_height = heights[i];

            for(int j = i+1; j < heights.length; j++){ //possible right side
                int right_height = heights[j];
                int lenght = 0; int over = 0;
                int height = Math.min(left_height, right_height);
                for(int k = i; k < j; k++){
                    lenght += (distances[k]+1);
                    if(k != i) over += heights[k];
                }
                lenght --;
                int size = height*lenght - (over);

                if (size > ret) ret = size;

                if(right_height >= left_height) break;
            }
        }
        return ret;
    }

    public static void printArray(int[][] input){
        for(int i = 0; i < input.length; i++){
            for(int j = 0; j < input[i].length; j++){
                System.out.print(Integer.toString(input[i][j]) + " ");
            }
            System.out.println("");
        }
    }
}
