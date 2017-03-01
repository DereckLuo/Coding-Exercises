package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here

        String input = "AAAAA";
        System.out.println("longest password is : " + Integer.toString(password(input)));

        int[][] A = new int[7][3];
        A[0][0] = 5; A[0][1] = 4; A[0][2] = 4;
        A[1][0] = 4; A[1][1] = 3; A[1][2] = 4;
        A[2][0] = 3; A[2][1] = 2; A[2][2] = 4;
        A[3][0] = 2; A[3][1] = 2; A[3][2] = 2;
        A[4][0] = 3; A[4][1] = 3; A[4][2] = 4;
        A[5][0] = 1; A[5][1] = 4; A[5][2] = 4;
        A[6][0] = 4; A[6][1] = 1; A[6][2] = 1;

        //int country = numCountry(A);
        //System.out.println("number of country is : " + Integer.toString(country));

        int[] a = {40, 40,100, 80, 20};
        int[] b = {3,3,2,2,3};
        int M = 3, X = 5, Y = 200;
        //int ret = lift(a,b,M,X,Y);
        //System.out.println("number of stops is : " + Integer.toString(ret));

    }

    /**
     * Longest vaid pathword in the given string
     *  Need at least 1 upper case, and no numbers allowed
     * @param S
     * @return
     */
    public static int password(String S) {
        // write your code in Java SE 8
        int ret  = -1;
        boolean cur_valid = false;
        int cur_length = 0;

        int idx = S.length()- 1;

        while(idx >= 0){
            char newChar = S.charAt(idx);
            if(Character.isDigit(newChar)){ //find a Number, break the substring
                if(cur_valid && cur_length > ret){
                    ret = cur_length;
                }
                cur_valid = false;
                cur_length = 0;
            }
            else{   //growing substring
                cur_length ++;
                if(Character.isUpperCase(newChar)) cur_valid = true;
            }
            idx --;
        }
        if(cur_valid && cur_length > ret) ret = cur_length;
        System.out.println("longest length is : " + Integer.toString(ret));
        return  ret;
    }

    /**
     * Given a matrix A represent a map, determine number of countries in the map
     * @param A
     * @return
     */
    public static int numCountry(int[][] A) {
        // write your code in Java SE 8
        if (A.length == 0){ //case given map is empty
            return 0;
        }

        int row = A.length;
        int column = A[0].length;
//        int ret = row*column;   //starting with the maximum number of countries
//
//        for(int i = 0; i < row; i++){
//            for(int j = 0; j < column; j++){
//                if(i != 0 && A[i][j] == A[i-1][j]){ //not top most row and can merge top
//                    ret --;
//                    System.out.println("Yes");
//                }
//                else if(j != 0 && A[i][j] == A[i][j-1]){    //not left most row and can merge left
//                    ret --;
//                    System.out.println("Yes");
//                }
//                else{
//                    System.out.println("NO");
//                }
//            }
//        }
//        return ret;

        HashMap<String, Integer> table = new HashMap<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                String key = Integer.toString(i)+Integer.toString(j);
                table.put(key, 0);
                System.out.println((table.get(key)));
            }
        }
        System.out.println(table.size());

        int ret = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                String key = Integer.toString(i)+Integer.toString(j);
                if(table.get(key) == 0){
                    ret ++;
                    expand(i,j, A[i][j], table, A);
                }
            }
        }
//        int ret = 0;
//        for(int i = 0; i < row ; i++){
//            for(int j = 0; j < column; j++){
//                String key = Integer.toString(i)+Integer.toString(j);
//                int color = A[i][j];
//                table.put(key, 1);
//                ret ++;
//                if(i != 0 && A[i-1][j] == color && table.get(Integer.toString(i-1)+Integer.toString(j)).equals(1)) ret --;
//                else if (j != 0 && A[i][j-1] == color && table.get(Integer.toString(i)+Integer.toString(j-1)).equals(1)) ret --;
//                else if (i+1 != row && A[i+1][j] == color && table.get(Integer.toString(i+1)+Integer.toString(j)).equals(1)) ret --;
//                else if(j+1 != column && A[i][j+1] == color && table.get(Integer.toString(i)+Integer.toString(j+1)).equals(1)) ret --;
//                System.out.println(ret);
//            }
//        }
        return ret;
    }

    private static void expand(int i, int j, int color, HashMap<String, Integer> table, int[][] A){
        table.put((Integer.toString(i)+Integer.toString(j)), 1);
        if(i != 0 && A[i-1][j] == color && table.get(Integer.toString(i-1)+Integer.toString(j)) == 0){ //expand top
            expand(i-1, j, color, table, A);
        }
        if (j != 0 && A[i][j-1] == color && table.get(Integer.toString(i)+Integer.toString(j-1)) == 0){ //expand left
            expand( i, j-1, color, table, A);
        }
        if (i+1 !=  A.length &&A[i+1][j] == color && table.get(Integer.toString(i+1)+Integer.toString(j)) == 0){ //expand down
            expand(i+1, j, color, table, A);
        }
        if(j+1 != A[i].length && A[i][j+1] == color && table.get(Integer.toString(i)+Integer.toString(j+1)) == 0){ //expand right
            expand(i, j+1, color, table, A);
        }
    }

    /**
     * Problem of lift: count number of stops the elevator makes
     */
    private static int lift(int[] A, int[] B, int M, int X, int Y) {
        // write your code in Java SE 8
        if(A.length == 0 || B.length == 0) return 0;

        int pos = 0; //tracking the position of queue
        int num = 0; int weight = 0;
        int stop = 0;

        HashMap<Integer, Integer> table = new HashMap<>();  //hash table store floor information

        while(pos < A.length){
            while(num <= X && weight <= Y && pos < A.length){
                num ++; weight += A[pos];
                table.put(B[pos], 1);
                pos++;
            }
            stop += table.size();
            num = 0; weight = 0;
            table.clear();
        }
        return stop;
    }
}
