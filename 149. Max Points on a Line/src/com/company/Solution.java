package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dereck on 0028, May, 28, 2017.
 */
public class Solution {

    /**
     * Recursive solution :
     *   For each point, it can be included in the line or not.
     *   Recursive on all points and return max number
     */
    public int maxPoints(Point[] points){
        return maxPointsRecur(0, points, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 0, 0);
    }

    /**
     * maxPoint recursive function
     */
    public int maxPointsRecur(int loc, Point[] points, int x0, int y0, double a, int same, int num){
        /*base case*/
        if (loc == points.length) {
            return num + same;
        }

        /*case chosing the first point */
        if (num == 0){
            int num1 = maxPointsRecur(loc+1, points, x0, y0, a, same, num);    // do not include the point
            int num2 = maxPointsRecur(loc+1, points, points[loc].x, points[loc].y, a, same,num+1);
            //System.out.println(Integer.toString(loc) + "|" + Integer.toString(num1) + " " + Integer.toString(num2) + " | " + Double.toString((double)points[loc].x) + " " + Double.toString((double)points[loc].y));
            return Math.max(num1, num2);
        }
        /*case of 2nd point*/
        else if(num == 1){
            double line_a;
            if (points[loc].x - x0 == 0.0){
                line_a = Double.MAX_VALUE;
            }
            else{
                line_a = (points[loc].y - y0)/(points[loc].x - x0);
            }

           //System.out.println("line parameters : " + Integer.toString(loc) + " | " + Double.toString(line_a));
            if(points[loc].x == x0 && points[loc].y == y0){
                return maxPointsRecur(loc+1, points, x0, y0, 0, same+1, num);
            }
            int num1 = maxPointsRecur(loc+1, points, x0, y0, 0, same, num); //do not include the point
            int num2 = maxPointsRecur(loc+1, points, x0, y0, line_a, same,num+1);
            return Math.max(num1, num2);
        }
        else{
            double ratio;
            if (points[loc].x - x0 == 0.0) {ratio = Double.MAX_VALUE;}
            else{ratio = (points[loc].y - y0)/(points[loc].x - x0);}
            if(ratio == a){
                return maxPointsRecur(loc+1, points, x0, y0, a, same,num+1);
            }
            else if (points[loc].x == x0 && points[loc].y == y0){
                return maxPointsRecur(loc+1, points, x0, y0, a, same,num+1);
            }
            else{
                return maxPointsRecur(loc+1, points, x0, y0, a, same, num);
            }
        }
    }

    public int maxPoints2(Point[] points) {
        if (points==null) return 0;
        if (points.length<=2) return points.length;

        Map<Integer,Map<Integer,Integer>> map = new HashMap<Integer,Map<Integer,Integer>>();
        int result=0;
        for (int i=0;i<points.length;i++){
            map.clear();
            int overlap=0,max=0;
            for (int j=i+1;j<points.length;j++){
                int x=points[j].x-points[i].x;
                int y=points[j].y-points[i].y;
                if (x==0&&y==0){
                    overlap++;
                    continue;
                }
                int gcd=generateGCD(x,y);
                if (gcd!=0){
                    x/=gcd;
                    y/=gcd;
                }

                if (map.containsKey(x)){
                    if (map.get(x).containsKey(y)){
                        map.get(x).put(y, map.get(x).get(y)+1);
                    }else{
                        map.get(x).put(y, 1);
                    }
                }else{
                    Map<Integer,Integer> m = new HashMap<Integer,Integer>();
                    m.put(y, 1);
                    map.put(x, m);
                }
                max=Math.max(max, map.get(x).get(y));
            }
            result=Math.max(result, max+overlap+1);
        }
        return result;


    }
    private int generateGCD(int a,int b){

        if (b==0) return a;
        else return generateGCD(b,a%b);

    }

}
