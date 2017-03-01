package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * 372. Super Pow
 * Your task is to calculate a^b mod 1337 where a is a positive integer and b i s an expremely lare positive integer
 * given in the form of an array
 * Example1:
 * a = 2
 * b = [3]
 * result: 8
 * Example2
 * a = 2
 * b = [1,0]
 * Result: 1024
 * Created by Dereck on 0021, January 21, 2017.
 */
public class Solution {
    int DIV = 1337;

    public int superPow(int a, int[] b){
        long ret = 0;
        long multi = new Long(a);

        int[] track = new int[b.length];

        while(!checkSame(track, b)){
            //System.out.println(Integer.toString(ret) + "~~~~~");
            trackAdd(track);
            while(ret > 1337){
                ret = ret - 1337;
            }
            //System.out.println(" ~~~~~" + Integer.toString(ret));
            if(ret == 0) ret += multi; else ret *= multi;

        }
        return (int)ret;
    }

    private boolean checkSame(int[] track, int[] b){
        for(int i = track.length-1; i >= 0; i--){
            if(track[i] != b[i]) return false;
        }
        return true;
    }

    private void trackAdd(int[] track){
        int idx = track.length-1;
        track[idx] += 1;
        while(track[idx] >= 10){
            track[idx] = 0;
            idx --;
            track[idx] += 1;
        }
    }

    /**
     * Remainder repeating pattern algorithm
     */
    public int superPowBetter(int a, int[] b) {
        if(a % 1337 == 0) return 0
        a = a % 1337;
        int[] next = new int[1337];
        int count = 0;
        int val = a;
        while(next[val] == 0){
            next[val] = val * a % 1337;
            val = next[val];
            count ++;
        }
        int m = mod(b,count);
        while(--m > 0)
            a = next[a];
            return a;
    }

    private int mod(int[] b , int c){
        int m = 0;
        for(int i = 0; i < b.length; i++){
            m = (m*10+b[i])%c;
        }
        return m;
    }
}
