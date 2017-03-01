package com.company;

/**
 * 28. Implement strStr()
 *  Implement strStr()
 *  Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack
 * Created by Dereck on 0026, January 26, 2017.
 */
public class Solution {
    public int strStr(String haystack, String needle){
        if(needle.length() == 0) return 0;
        int idx = 0; boolean start = false;
        int start_idx = -1;
        for(int i = 0; i < haystack.length(); i++){
            if(haystack.charAt(i) == needle.charAt(idx) && !start){
                start_idx = i; start = true;
                idx ++;
            }
            else{
                start_idx = -1; start = false;
                idx = 0;
            }
            if(idx >= needle.length()) return start_idx;
        }
        return -1;
    }
}
