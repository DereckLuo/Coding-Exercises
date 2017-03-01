package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        // Question 1
//        int[] array;
//        array = new int[] {8,2,2,2,2,2,2,2,2};
//
//        int[] output = ArrayProcessor.processArray(array);
//        System.out.println(output);

        //Question 2
//        String[] string = {"aababcabcd", "aababcabcd"};
//        int[] mult = {3,2};
//        int[] ret = countChars.countCharacters(string, mult);
//        for(Integer num: ret) System.out.println(num);

        //Question 4
        int[] heights = {6,7,4,3,5};
        int[] distance = {0,0,0,0};
        int ret = MaxLake.getMaxLakeVolume(heights, distance);
        System.out.println("The maximum lake size is : " + Integer.toString(ret));
    }
}
