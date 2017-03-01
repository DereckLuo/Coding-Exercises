package com.company;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * The 9 rings puzzle:
 *  Given a string with length n ,and contains all 1s
 *  The puzzle allows two legal moves :
 *      1. You can always flip the 1st ( = rightmost) bit
 *      2. If the bit string ends with exactly i 0s, you can flip the (i+2)th bit
 *  The goal is to transform a string of n 1s into a string of n 0s.
 *  //Example:
 *     11111 -> 11110 -> 11010 -> 11011 -> 11001 -> 11000 -> 01000 -> 01001 ->
 *     01011 -> 01010 -> 01110 -> 01111 -> 01101 -> 01100 -> 00100 -> 00101 ->
 *     00111 -> 00110 -> 00010 -> 00011 -> 00001 -> 00000
 * Algorithm requires to print out the final steps
 * Created by Dereck on 0024, January 24, 2017.
 */
public class Solution {
    public void solvingpuzzle(int n){
        String s = "";
        String solve = "";
        for(int i = 0; i < n; i++){
            s = s + "1";
            solve = solve + '0';
        }


        Map<String, Integer> table = new HashMap<>();
        Comparator<Node> comparator = new NodeComparator();
        PriorityQueue<Node> queue = new PriorityQueue<>(11, comparator);

        Node root = new Node(s, 0, "");
        root.updateScore(Heuristics(s));
        table.put(s, 1);
        queue.add(root);

        int moves = 1;

        while(!queue.isEmpty()){
            Node top = queue.peek();
            moves ++;
            String topString = top.getString();
            //System.out.println("size is : " + Integer.toString(queue.size()) + " string is : " + topString + " steps are : " + top.getSteps());

            Node step1 = moveOne(topString, 1+top.getPast(), top.getSteps());
            Node step2 = moveTwo(topString, 1+top.getPast(), top.getSteps());


            String child1 = step1.getString();
            String child2 = step2.getString();
            if(child1.equals(solve)){
                System.out.println(step1.getSteps());
                System.out.println("Number of moves took : " + Integer.toString(moves));
                return;
            }
            else if (child2.equals(solve)){
                System.out.println(step2.getSteps());
                System.out.println("Number of moves took : " + Integer.toString(moves));
                return;
            }

            queue.poll();
            if(table.get(child1) == null){
                table.put(child1, 1);
                queue.add(step1);
            }
            if(table.get(child2) == null){
                table.put(child2, 1);
                queue.add(step2);
            }
        }
        System.out.println("No solution found!");
    }

    private int Heuristics(String s){
        int ret = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1') ret ++;
        }
        return ret;
    }

    private Node moveOne(String s, int past, String step){
        String newString = "";
        for(int i = 0; i < s.length()-1; i++){
            newString = newString + s.charAt(i);
        }
        if(s.charAt(s.length()-1) == '1') newString += '0';
        else newString += '1';
        Node temp = new Node(newString, past, step+"1");
        //temp.updateString(newString);
        temp.updateScore(past + Heuristics(newString));

       // System.out.println("Input String is : " + s + " Move1 string : " + temp.getString() + " steps are : " + temp.getSteps());

        return temp;
    }

    private Node moveTwo(String s, int past, String step){
        String newString = "";
        int num_zero = 0;
        int idx = s.length()-1;
        while(s.charAt(idx) == '0'){
            idx --; num_zero ++;
        }
        num_zero += 2;
        for(int i = 0; i < s.length(); i++){
            if( i == s.length() - num_zero){
                if(s.charAt(i) == '1') newString += '0';
                else newString += '1';
            }
            else newString += s.charAt(i);
        }
        Node temp = new Node(newString, past, step + Integer.toString(num_zero));
        temp.updateScore(past + Heuristics(newString));

        //System.out.println("Input String is : " + s + " Move2 string : " + temp.getString() + " steps are : " + temp.getSteps());

        return temp;
    }
}
