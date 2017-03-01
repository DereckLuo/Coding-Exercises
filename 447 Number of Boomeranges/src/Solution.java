import java.util.HashMap;
import java.util.Map;

/**
 * 447. Number of Boomeranges
 * Given n points in the plane that are all pairwise distinct, a "boomerange" is a tuple of points (i, j, k) such
 * that the distance between i and j equals the distance between i and k (the order of the tuple matters)
 * Find the number of bommeranges. You may assume that n will be at most 500 and coordinates of points are all
 * in the range [-10000, 10000]
 *
 * Example:
 *  Input:
 *      [[0,0],[1,0],[2,0]]
 *  Output:
 *      2
 *
 * Explanation:
 *  The two boomeranges are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 *
 * Created by Dereck on 0016, January 16, 2017.
 */
public class Solution {
    public static void main(String[] args) {
        int[][] input = new int[][]{
                {0, 0}, {1, 0}, {2, 0},{3,0}
        };
        int output = numberOfBoomeranges(input);
        System.out.printf("The number of boomerange is : " + Integer.toString(output));

    }

    public static int numberOfBoomeranges(int[][] points) {
        int ret = 0;
        Map<String, Double> table = new HashMap<>();   //distance between all points

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; ++j) {
                double x_distance = points[j][0] - points[i][0];
                double y_distance = points[j][1] - points[i][1];
                double distance = Math.sqrt((x_distance * x_distance) + (y_distance * y_distance));
                String key = Integer.toString(Math.max(i, j)) + "," + Integer.toString(Math.min(i, j)); //key: largeidx,smallidx
                table.put(key, distance);
            }
        }

        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> distance_map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    String check_key = Integer.toString(Math.max(i, j)) + "," + Integer.toString(Math.min(i, j));
                    Double check_dist = table.get(check_key);
                    if (distance_map.get(check_dist) == null) {
                        distance_map.put(check_dist, 1);
                    } else {
                        distance_map.put(check_dist, distance_map.get(check_dist) + 1);
                    }
                }
            }

            for (Map.Entry<Double, Integer> entry : distance_map.entrySet()) {
                int value = entry.getValue();
                if (value > 1) {
                    //TODO: compute value choose 2, need to find a library for that
                    ret += 2 * choose(value, 2);
                }
            }
        }


        return ret;
    }

    public static int choose(int total, int choose){
        if(total < choose){
            return 0;
        }
        if(choose == 0 || choose == total){
            return 1;
        }
        return choose(total-1, choose-1) + choose(total-1, choose);
    }

    /**
     * O(n^2) Solution
     * Time complexity: O(n^2)
     * Space complexity: O(n)
     */
    public static int numberOfBoomerangesFast(int[][] points){
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < points.length; i++){
            for(int j = 0; j < points.length; j++){
                if(i == j) continue;    //no distance between same point
                int d = getDistance(points[i], points[j]);
                map.put(d, map.getOrDefault(d,0) + 1);
            }
            for(int value : map.values()){
                res += value*(value-1);
            }
            map.clear();
        }
        return res;
    }

    public static int getDistance(int[] a, int[] b){
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];
        return dx*dx + dy*dy;
    }
}
