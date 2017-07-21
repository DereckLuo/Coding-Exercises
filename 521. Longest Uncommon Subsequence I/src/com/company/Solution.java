package com.company;

import java.util.HashMap;

/**
 * Created by derec on 0001, June, 1, 2017.
 */
public class Solution {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
