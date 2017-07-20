package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by derec on 0028, May, 28, 2017.
 */
public class Solution {
    /**
     * 2 Heap tracking of median solution
     * equivalent to binary search
     */
    public double[] medianSlidingWindow(int[] nums, int k){
        double[] ret = new double[nums.length-k+1];
        if(k == 1){
            for(int i = 0; i < ret.length; i++){
                ret[i] = (double)nums[i];
            }
            return ret;
        }

        int midloc = (k+1)/2-1;
        int[] temp = new int[k];
        System.arraycopy(nums, 0, temp, 0, k);
        Arrays.sort(temp);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(1, Collections.reverseOrder());

        for(int i = 0; i < temp.length; i++){
            if(i > midloc){
                minHeap.add(temp[i]);
            }
            else{
                maxHeap.add(temp[i]);
            }
        }
        extractMedian(ret, 0, minHeap.size(), maxHeap.size(), minHeap, maxHeap);

        for(int i = 1; (i+k-1) < nums.length; i++){
            int remove = nums[i-1]; int add = nums[i+k-1];

            /*remove element*/
            if(remove >= minHeap.peek()){
                minHeap.remove(remove);
            }
            else if(remove <= maxHeap.peek()){
                maxHeap.remove(remove);
            }
            else{
                System.out.println("Warning! remove failed!");
            }
//            System.out.println(" ~ min size : " + Integer.toString(minHeap.size()) + " max size :" + Integer.toString(maxHeap.size()));

            /*add element*/
            if(minHeap.size() != 0 && add >= minHeap.peek()){
                minHeap.add(add);
            }
            else if(maxHeap.size() != 0 &&  add <= maxHeap.peek()){
                maxHeap.add(add);
            }
            else{
                if(minHeap.size() == 0) minHeap.add(add);
                else{ maxHeap.add(add);}
//                System.out.println("Warning! add failed!");
            }
//            System.out.println(" ~ ~ min size : " + Integer.toString(minHeap.size()) + " max size :" + Integer.toString(maxHeap.size()));

            /*rebalance heaps*/
            if(minHeap.size() >= maxHeap.size() + 2){
                maxHeap.add(minHeap.poll());
            }
            else if(maxHeap.size() >= minHeap.size() + 2){
                minHeap.add(maxHeap.poll());
            }
            //System.out.println(" ~ ~ ~ min size : " + Integer.toString(minHeap.size()) + " max size :" + Integer.toString(maxHeap.size()));

            extractMedian(ret, i, minHeap.size(), maxHeap.size(), minHeap, maxHeap);
        }

        return ret;
    }

    private void extractMedian(double[] ret, int idx, int minSize, int maxSize, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap){
        if(minSize > maxSize){
            ret[idx] = (double)minHeap.peek();
        }
        else if(maxSize > minSize){
            ret[idx] = (double)(maxHeap.peek());
        }
        else{
            ret[idx] = (double)((long)minHeap.peek() + (long)maxHeap.peek())/2.0;
        }
    }

    /*trivial but slow solution*/
    public double[] medianSlidingWindowTime(int[] nums, int k) {
        double[] ret = new double[nums.length-k+1];
        int midloc = (k+1)/2-1;
        for(int i = 0; (i+k-1) < nums.length; i++){
            int[] temp = new int[k];
            System.arraycopy(nums, i, temp, 0, k);
            Arrays.sort(temp);
            //System.out.println(Arrays.toString(temp));
            if(k % 2 == 0){
                ret[i] = (double)((long)temp[midloc] + (long)temp[midloc+1])/2.0;
            }
            else{
                ret[i] = (double)(temp[midloc]);
            }
        }

        return ret;
    }



}
