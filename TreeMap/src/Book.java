import com.sun.org.apache.bcel.internal.generic.RET;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * Example for training on Treemap
 * Created by Dereck on 0010, January 10, 2017.
 */



public class Book {

    private static TreeMap<Double, Integer> bids_tree = new TreeMap<Double, Integer>();
    private static TreeMap<Double, Integer> asks_tree = new TreeMap<Double, Integer>();

    /**
     * Main function:
     *  called when program begins
     * @param args
     */
    public static void main(String[] args){
        System.out.println("Hello world!");
        buildingTree();
        printTree();
        ArrayList<RetailState> new_bidstop = new ArrayList<RetailState>();
        for(int i = 7; i > 4; i--){
            RetailState temp = new RetailState((double)i, 10);
            new_bidstop.add(temp);
        }
        topThreeBids(new_bidstop);
        printTree();

    }

    public static void buildingTree(){
        //building the bids tree
        for(int i = 0; i < 10; i++){
            bids_tree.put((double)i, 10);
        }
        //building the ask tree
        for(int i = 15; i < 25; i++){
            asks_tree.put((double)i, 10);
        }
    }

    /**
     * Function printTree
     */
    public static void printTree(){
        System.out.println("Bids tree is : ");
        System.out.println(bids_tree.size());
        for(double entry: bids_tree.descendingKeySet()){
            String output = Double.toString(entry) + "," + Integer.toString(bids_tree.get(entry));
            System.out.println(output);
        }

        System.out.println("Ask tree is :");
        System.out.println(asks_tree.size());
        for(Map.Entry<Double, Integer> entry: asks_tree.entrySet()){
            String output = Double.toString(entry.getKey()) + "," + Integer.toString(entry.getValue());
            System.out.println(output);
        }
    }

    /**
     * Function topThreeBids
     * Given the current top three element, update the tree
     * Situations: Might be the same top three element with different values
     *             Might be different top three elements (greater than current top)
     *             Might be different top three elements (less than current top)
     * Input:
     *      Array of the top three current element, using to update local book
     */
    public static void topThreeBids(ArrayList<RetailState> input){
        System.out.println("Top Three Bids ~~~~~~~");
        //popping off all entries that are larger than the current top three
        while(bids_tree.descendingMap().firstKey() >= input.get(2).price){
            Map.Entry<Double, Integer> first = bids_tree.descendingMap().pollFirstEntry();
        }
        //pushing back the current top three
        for(int i = 0; i < input.size(); i++){
            bids_tree.put(input.get(i).price, input.get(i).volum);
        }
    }

    /**
     * Function topThreeAsks
     *  Given the current top three element, update the tree
     *  Situation: Doesn't matter
     *  Input:
     *      Array of the top three current element, using to update local book
     */
    public static void topThreeAsks(ArrayList<RetailState> input){
        System.out.println("Top Three Asks ~~~~~~");
        //popping off all entries that are larger than the current top three
        while(asks_tree.firstKey() <= input.get(2).price){
            bids_tree.pollFirstEntry();
        }
        //pushing back the current top three
        for(int i = 0; i < input.size(); i++){
            asks_tree.put(input.get(i).price, input.get(i).volum);
        }
    }


}
