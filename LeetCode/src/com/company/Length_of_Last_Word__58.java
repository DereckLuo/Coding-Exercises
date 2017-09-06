package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * 58. Length of Last Word:
 *      Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 *      return the length of last word in the string
 *
 *      if the last word does not exist, return 0.
 */
public class Length_of_Last_Word__58 {
    public int lengthOfLastWord(String s){
        String[] arr = s.split(" ");
        return arr.length == 0 ? 0 : arr[arr.length-1].length();
    }
}
