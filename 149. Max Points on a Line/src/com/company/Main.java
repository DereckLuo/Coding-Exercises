package com.company;


import java.util.ArrayList;

/**
 * 149. Max Points on a Line
 *  Given n points on a 2D plane, find the maximum number of points that lies on the same straight line.
 */
public class Main {

    public static void main(String[] args) {

        Point[] points = createPoints();
        printPoints(points);
        Solution sol = new Solution();
        int output = sol.maxPoints(points);
        System.out.println(" \nMax points in line is " + Integer.toString(output));
    }


    /* Generate 2D points */
    public static Point[] createPoints(){
        Point[] ret = new Point[3];
//        for(int i = 0; i < ret.length; i++){
//            ret[i] = new Point(0, i);
//        }
        ret[0] = new Point(1,0);
        ret[1] = new Point(1,0);
        ret[2] = new Point(0,0);
        return ret;
    }

    /* Print points */
    public static void printPoints(Point[] point){
        for(Point p: point){
            System.out.print(Integer.toString(p.x) + Integer.toString(p.y));
            System.out.print(" ");
        }
        System.out.println("\n");
    }
}
