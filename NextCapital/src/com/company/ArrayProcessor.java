package com.company;

/**
 * Created by Dereck on 0023, February 23, 2017.
 * four rules to change array
 */
public class ArrayProcessor {

    static int[] processArray(int[] array){
        boolean apply;
        for(int i = 0; i < array.length; i++){
            apply = false;
            if(i > 0 && i % 2 == 0){
                array[i] += array[i-1];
                apply = true;
            }
            if (i > 0 && i % 3 == 0 && i < array.length-1){
                int temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
                apply = true;
            }
            if (i % 5 == 0 && i > 0){
                array[i] *= 2;
                apply = true;
            }
            if (i % 7 == 0 || !apply){
                array[i] -= 1;
            }

        }
        return array;
    }
}
