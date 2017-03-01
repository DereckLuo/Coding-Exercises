package com.company;

import java.util.Collections;
import java.util.HashMap;

/**
 * Created by Dereck on 0023, February 23, 2017.
 */
public class countChars {

    static int[] countCharacters(String[] strings, int[] multiples) {
        int[] ret = new int[strings.length];

        for(int i = 0; i < strings.length; i++){
            HashMap<Character, Integer> table = new HashMap<>();
            String line = strings[i];
            for(int j = 0; j < line.length(); j++){
                char key = line.charAt(j);
                if(table.containsKey(key)){
                    table.put(key, table.get(key) + 1);
                }
                else{
                    table.put(key, 1);
                }
            }
            int count = 0; int mult = multiples[i];
            for(Integer num : table.values()){
                if(num % mult == 0) count ++;
            }
            ret[i] = count;
        }
        return ret;
    }
}
