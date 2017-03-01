package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String needle = "";
        String haystack = "";
        Solution sol = new Solution();

        int ret = sol.strStr(haystack,needle);
        System.out.println(ret);
    }
}
