package com.company;

/**
 * 65. Valid Number
 * Validate if a given string is numeric
 * Some examples:
 * "0" => true
 * "0.1" => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. You should gather all
 * requirements up front before implementing one
 * Created by Dereck on 0021, January 21, 2017.
 */
public class Solution {
    public boolean isNumber(String s){
        boolean is_a_number = false;
        boolean allow_leading_zero = true;
        boolean allow_minus_sign = true;
        boolean allow_decimal_point = true;
        boolean starts_number = false;
        boolean start_ending_space = false;

        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(Character.isDigit(curr)){    //case it is a number
                //allow_leading_space = false;
                is_a_number = true;
                starts_number = true;
                if(start_ending_space) return false;
            }
            else if(curr == '-'){
                //allow_leading_space = false;
                if(allow_minus_sign) allow_minus_sign = false;
                else return false;
            }
            else if(curr == '.'){
                //allow_leading_space = false;
                if(allow_decimal_point) allow_decimal_point = false;
                else return false;
            }
            else if(curr == ' '){
                if(starts_number) start_ending_space = true;
            }
            else return false;
        }
        return is_a_number;
    }
}
