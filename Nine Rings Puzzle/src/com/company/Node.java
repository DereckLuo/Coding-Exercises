package com.company;

/**
 * Created by Dereck on 0024, January 24, 2017.
 */
public class Node {
    private String s;
    private int score;
    private int past;
    private String steps ="";

    public Node(String input, int Past, String Step){
        s = input;
        past = Past;
        steps = Step;
    }

    public int getScore(){
        return score;
    }

    public String getString(){
        return s;
    }

    public int getPast(){
        return past;
    }

    public String getSteps(){return steps;}

    public void updateScore(int input){
        score = input;
    }

}
