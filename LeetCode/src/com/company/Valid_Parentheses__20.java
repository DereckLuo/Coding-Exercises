package com.company;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{' '}', '[', ']',
 * determine if the input string is valid
 */
public class Valid_Parentheses__20 {
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if(stack.isEmpty()) stack.push(c);
            else{
                Character top = stack.peek();
                if((c == '(' && top == ')') || (c == ')' && top == '(') ||
                        (c == '{' && top == '}') || (c == '}' && top == '{') ||
                        (c == '[' && top == ']') || (c == ']' && top == '[')){
                    stack.pop();
                }
                else{stack.push(c);}
            }

        }
        return stack.size() == 0? true:false;
    }
}
