import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 488. Zuma Game
 *  Think about Zuma Game. You have a row of balls on the table, Colored R, Y, B, G and W. You also have several balls in your hand
 *  Each time, you may choose a ball in your hand, and insert it into the row (including the leftmost place and right most place).
 *  Then, if there is a group of 3 or more balls in the same color touching, remove these balls.
 *  Keep doing this until no more balls can be removed
 *
 *  Example:
 *  Input: "WRRBBW", "RB"
 *  Output -1
 *
 *  Input "WWRRBBWW", "WRBRW"
 *  Output 2
 *  Explanation WWRRBBWW --> WWRR[R]BBWW --> WWBBWW --> WWBB[B]WW --> WWWW --> empty
 * Created by Dereck on 0014, January 14, 2017.
 */
public class Solution {
    public static void main(String[] args){
        String board = "WRRBBW";
        String hand = "RB";

        int ret = findMinStep(board, hand);
        System.out.printf(Integer.toString(ret));
    }
    public static int findMinStep(String board, String hand) {
        int ret = -1;
        //load both board and hand
        Map<Character, Integer> hand_map = new HashMap<Character, Integer>();
        for(char i : hand.toCharArray()){
            if(hand_map.get(i) == null){
                hand_map.put(i, 1);
            }
            else{
                hand_map.put(i, hand_map.get(i)+1);
            }
        }
        System.out.println("hand map size is : " + Integer.toString(hand_map.size()));


        ArrayList<ArrayList<Character>> board_list = new ArrayList();
        ArrayList<Character> temp = new ArrayList();

        board_list.add(temp);
        int idx = 0;

        for(char i : board.toCharArray()){
            if(board_list.get(idx).isEmpty() || i == board_list.get(idx).get(0)){
                board_list.get(idx).add(i);
            }
            else{
                ArrayList<Character> next = new ArrayList();
                board_list.add(next);
                idx += 1;
            }
        }

        for(int i = 0; i < board_list.size(); i++){
//            for(int j = 0; j < board_list.get(i).size(); j++){
//                System.out.printf(Character.toString(board_list.get(i).get(j)) + " ");
//            }
            System.out.println(board_list.get(i).size());
        }

        return  ret;
    }
}
