package com.company;

import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression
 * Some examples:
 *  ["2","1","+","3","*"] -> ((2+1)*3)->9
 *  ["4","13","5","/","+"] -> (4+(13/5))->6
 * Created by Dereck on 0021, January 21, 2017.
 */
public class Solution {
    public int evalRPN(String[] tokens){
        if(tokens == null) return 0;

        Stack<Integer> container = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            String current = tokens[i];
            if(!current.equals("+") && !current.equals("-") && !current.equals("*") && !current.equals("/")){
                container.push(Integer.valueOf(current));
            }
            else{
                int right = container.pop();
                int left = container.pop();
                if(current.equals("+")) container.push(left + right);
                if(current.equals("-")) container.push(left-right);
                if(current.equals("*")) container.push(left*right);
                if(current.equals("/")) container.push(left/right);
            }
        }
        return container.pop();
    }
}
