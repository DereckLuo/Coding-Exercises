package com.company;

/**
 * In LOL world, there is a hero called Teemo and his attacking can make his
 * enemy Ashe be in poisoned condition. Now, given the Teemo's attacking ascend-
 * ing time series towards Ashe and the poisoning time duration per Teemo's
 * attacking, you need to output the total time that Ashe is in poisoned condition.

 You may assume that Teemo attacks at the very beginning of a specific time point,
 and makes Ashe be in poisoned condition immediately.
 */
public class Temmo_Attacking__495 {
    public int findPoisonedDuration(int[] timeSeries, int duration){
        if(timeSeries.length == 0 || duration <= 0) return 0;
        //Assume timeSeries is sorted
        boolean poisoned = false;
        int count = 0, dur = 0;
        int index = 0;
        for(int i = 1; i <= timeSeries[timeSeries.length-1] + duration; i++){
            if(index < timeSeries.length && timeSeries[index] == i){
                poisoned = true;
                dur = duration;
                index += 1;
            }
            if(poisoned){
                count += 1; dur -= 1;
                if(dur == 0) poisoned = false;
            }
        }
        return count;
    }
}
