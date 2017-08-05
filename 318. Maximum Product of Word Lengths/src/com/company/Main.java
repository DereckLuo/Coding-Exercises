package com.company;

public class Main {

    /**
     * 318. Maximum Product of Word Lengths
     *  Given a string array words, find the maximum value of length(word[i])*length(word[j])
     *  where the two words do not share common letters. You may assume each word will contain only
     *  lower case letters. if no such two words exist, return 0
     *  Example 1:
     *  Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
     *  return 16 -- "abcw" * "xtfn"
     */
    public static void main(String[] args) {
	// write your code here
        String[] input = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};

        Solution sol = new Solution();
        int output = sol.maxProduct(input);
        System.out.println("Maximum word product is : " + Integer.toString(output));
    }
}
