package com.company;

import java.util.HashMap;

/**
 * 76. Minimum Window Substring:
 *      Given a string S and a string T, find the minimum window in S which will
 *      contain all the characters in T in complexity O(n)
 *
 *      For example,
 *      S = "ADOBECODEBANC"
 *      T = "ABC"
 *      Minimum window is "BANC"
 */
public class Minimum_Window_Substring__76 {
    /**
     * Idea:
     *  1. Use two pointers: start and end to represent a window
     *  2. Move end to find a valid window
     *  3. When a valid window is found, move start to find a smaller window
     *
     */
    public String minWindow(String s, String t){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            map.put(t.charAt(i), 1);
        }

//        int counter = t.length(), begin = 0, end = 0, d = Integer.MAX_VALUE, head = 0;
        int start = 0, end = 0, counter = t.length(), minStart = 0, minLength = Integer.MAX_VALUE;
        int size = s.length();

        //move end to find a valid window
        while(end < size){
            //if char in s exists in t, decrease counter
            if(map.containsKey(s.charAt(end))) counter --;
            //Decrease char in the map value by 1
            int temp = map.containsKey(s.charAt(end)) ? map.get(s.charAt(end)) : 0;
            map.put(s.charAt(end), temp-1);
            end ++;

            //when we found a valid window, move start to find smaller window
            while(counter == 0){
                if(end - start < minLength){
                    minStart = start; minLength = end-start;
                }
                temp = map.containsKey(s.charAt(start)) ? map.get(s.charAt(start)) : 0;
                map.put(s.charAt(start), temp+1);
                //when char exists in t, increase counter.
                if(map.containsKey(s.charAt(start))) counter ++;
                start ++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minLength);
    }

    /**
     * A template for most find substring problem
     */
    int findSubstring(String s){
        HashMap<Object, Object> map = new HashMap<>();
        int counter; //check whether the substring is valid
        int begin = 0, end = 0; //two pointers for subtring search
        int sublength; //length of substring

        for() { /* initialize the hash map here */}

        //moving end pointer to find a possible substring
        while(end < s.length()){
            if(map.containsKey(s.charAt(end))){/* modify counter here */};

            //find the end of the possible substring, moving the begin to find condition
            while(/* counter condition */){
                /* update sublength here if finding minimum */
                /* increase begin to make it invalid/valid again*/
                if(map.containsKey(s.charAt(begin))){ /* modify counter here */}
            }
            /* update sublength here if finding maximum/minimum */
        }
        return sublength;
    }
}
