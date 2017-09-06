package com.company;

import java.util.HashMap;

/**
 * 205. Isomorphic Strings
 *      Given two strings s and t, determine if they are isomorphic
 *      Two strings are isomorphic if the characters in s can be replaced to get t
 *      All occurrences of a character must be replaced with another character while preserving the
 *      order of characters.
 *      No two characters may map to the same character but a character may map to itself
 *
 *      For example:
 *          Given "egg", "add", return true
 *          Given "foo", "bar", return false
 *          Given "paper", "title", return true
 */
public class Isomorphic_Strings__205 {
    public boolean isIsomorphic(String s, String t){
        if(s.length() != t.length()) return false;

        HashMap<Character, Character> table1 = new HashMap<>();
        HashMap<Character, Character> table2 = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char sChar = s.charAt(i), tChar = t.charAt(i);
            if(!table1.containsKey(sChar) && !table2.containsKey(tChar)){
                table1.put(sChar, tChar); table2.put(tChar, sChar);
            }
            else{
                if(!table1.containsKey(sChar) || !table2.containsKey(tChar)) return false;
                if(table1.get(sChar) != tChar || table2.get(tChar) != sChar) return false;
            }
        }
        return true;
    }
}
