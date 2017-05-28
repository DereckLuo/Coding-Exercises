package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dereck on 0004, March 4, 2017.
 */
class Memory {
    private int memsize = 200;
    private int emptyspot = 200;

    /**
     * Initialize memory
     * 1x200 memory array to store processor id
     * starting insert from position 1
     */
    int[] initMemory(){
        int array[] = new int[memsize];
        return array;
    }

    /**
     * Initialize bookkeeping
     * 200x200 bookkeeping to store processor and their array location
     * process 0 to process 199
     */
    int[][] initBookkeeping(){
        int bookkeeping[][] = new int[memsize][memsize];
        return bookkeeping;
    }

    /**
     * allocate check:
     * Given a process number, and process size, check if we can allocate it
     */
    boolean allocateCheck(int number, int size, int[] memory, int[][] bk){
        if(number < 0 || number > 199) return false;   //case process out of bounds
        if(bk[number][0] != 0) return false;            //process in the memory
        if(size > emptyspot) return false;              //not enough space
        return true;
    }

    /**
     * allocatememory
     * allocate the memory for the given process, update memory, bk and emptyspot
     */
    void allocate(int number, int size, int[] memory, int[][] bk){
        int memidx = 1; int bkidx = 0;
        int totalsize = size;
        while(totalsize != 0){
            if(memory[memidx] == 0){
                memory[memidx] = number;
                bk[number][bkidx] = memidx;
                emptyspot --; totalsize --;
            }
            memidx ++; bkidx++;
        }
    }


    /**
     * Print memory
     */
    void printMemory(int[] arr){
        for(Integer num : arr){
            System.out.print(Integer.toString(num) + " ");
        }
        System.out.println("");
    }

    /**
     *
     */
}
