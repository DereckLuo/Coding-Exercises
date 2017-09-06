package com.company;

/**
 * 9. Palindrome Number
 *  Determine whether an integer is a palindrome. Do this without extra space
 */
public class Palindrome_Number__9 {
    public boolean isPalindrome(int x){
        String num = Integer.toString(x);
        int begin = 0, end = num.length()-1;
        while(begin <= end){
            if(num.charAt(begin) != num.charAt(end)) return false;
            begin += 1; end -= 1;
        }
        return true;
    }
}
