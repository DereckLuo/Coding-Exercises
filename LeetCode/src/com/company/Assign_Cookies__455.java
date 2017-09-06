package com.company;

import java.util.Arrays;

/**
 * 455. Assign Cookies
 *      Assume you are an awesome parent and want to give your children some cookies. But, you should
 *      give each child at most one cookie. Each child I has a greed factor g, which is the
 *      minimum size of a cookie that the child will be content with; and each cookie j has
 *      a size sj. if sj >= gj, we can assign the cookie j to the child i, and the child will
 *      be content. Your goal is to maximize the number of your content children and output the
 *      maximum number.
 *
 *      Example:
 *      Input: [1,2,3], [1,1]
 *      Output: 1
 *      Explain: 3 children, 2 cookies, but the both cookie can only satisfy 1st child
 *
 *      Input: [1,2], [1,2,3]
 *      Output: 2
 */
public class Assign_Cookies__455 {
    public int findCountentChildren(int[] g, int[] s){
        //since the purpose is to satisfy as many children as possible
        //Therefore, we can try from the easiest child with smallest cookie and work our way up
        int ret = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        int gIndex = 0, sIndex = 0;
        while(sIndex < s.length && gIndex < g.length){

            if(s[sIndex] >= g[gIndex]){
                sIndex ++; gIndex ++; ret ++;
            }
            else{
                sIndex ++;
            }
        }
        return ret;
    }
}
