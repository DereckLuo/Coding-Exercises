package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        // initialize memory class
        Memory ram = new Memory();

        //initialize memory array
        int[] arr = ram.initMemory();

        //initialize bookkeeping structure
        int[][] bk = ram.initBookkeeping();

        //allocating a memory
        int pcnum = 1; int pcsize = 10;
        if(ram.allocateCheck(pcnum, pcsize, arr, bk)){
            System.out.println(" Memory allocate success ! ");
            ram.allocate(pcnum, pcsize, arr, bk);
        }
        else{
            System.out.println(" Memory allocation failed ! ");
        }


        ram.printMemory(arr);
    }
}
