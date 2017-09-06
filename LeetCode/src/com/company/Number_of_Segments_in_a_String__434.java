package com.company;

/**
 * 434. Number of Segments in a String
 *      Count the number of segments in a string, where a segment is defined to be
 *      a contiguous sequence of non-space characters
 *      Plase not that the string does not contain any non-printable char
 *
 *      Example:
 *          Input: "Hello, my name is John"
 *          Output: 5
 */
public class Number_of_Segments_in_a_String__434 {
    public int contSegments(String s){
        int ret = 0; boolean flag = false;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c != ' ' && !flag){
                flag = !flag; ret += 1;
            }
            else if(c == ' ' && flag){
                flag = !flag;
            }
        }
        return ret;
    }
}
