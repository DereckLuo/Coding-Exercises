package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * 3. Longest Substring Without Repeating Characters
 *
 * Given a string, find the length of the longest substring without repeating characters
 *
 * Example
 * Given "abcabcbb", the answer is "abc", which the length is 3
 * Given "bbbbbb", the answer is "b", with the length of 1
 * Given "pwwkew", the answer is "wke", the length of 3
 *
 * Created by Dereck on 0001, March 1, 2017.
 */
public class Solution {
    /**
     * Using DP try to solve this :
     * i and j are index of the substring s
     * table[i][j] indicate if the substring i to j is valid
     * array [i][j] contains dictionary, and if it is a substring or not
     */
    public int lengthOfLongestSubstring(String s){
        int ret = 1;
        if(s.isEmpty()) return 0;

        //2D array to store information
        List<List<String>> table = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            List<String> line = new ArrayList<>();
            for(int j = 0; j < s.length(); j++) {
                if (i == j) {
                    line.add(Character.toString(s.charAt(i)));
                }
                else line.add("");
            }
            table.add(line);
        }

        for(int i = 0; i < s.length()-1; i++){ //starting point index
            for(int j = i+1; j < s.length(); j++){
                CharSequence newchar = Character.toString(s.charAt(j));
                String old = table.get(i).get(j-1);
                if(!old.equals("")){ //case previous is valid
                    if(old.contains(newchar)){
                        table.get(i).set(j, "");
                    }
                    else{
                        String newstring = old + Character.toString(s.charAt(j));
                        table.get(i).set(j, newstring);
                        if(newstring.length() > ret) ret = newstring.length();
                    }
                }
                else{
                    table.get(i).set(j, "");
                }
            }
        }
        printTable( table);
        return ret;
    }

    public void printTable(List<List<String>> table){
        for(int i = 0; i < table.size(); i++){
            for(int j = 0; j < table.get(i).size(); j++){
                System.out.print(table.get(i).get(j));
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

}
