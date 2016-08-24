package com.interview.shuffleanarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. 
 * Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();

 * @author mcgu
 *
 */
public class Solution {
//	List<Integer> originList=new ArrayList<>();
	int[] originArray;
    public Solution(int[] nums) {
//    	originList.clear();
//        for (int i = 0; i < nums.length; i++) {
//			originList.add(nums[i]);
//		}
        originArray= Arrays.copyOf(nums, nums.length);
        
        
    }
    public static void main(String args[])
    {
    	Solution mySolution=new Solution(new int[]{1,2,3,4,5,6});
    	System.out.println(Arrays.toString(mySolution.shuffle()));
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return originArray;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shuffleArray=Arrays.copyOf(originArray, originArray.length);
        Set<Integer> indexSet=new HashSet<>();
        List<Integer> indexList=new ArrayList<>();
        for (int i = 0; i < shuffleArray.length; i++) {
			indexSet.add(i);
			indexList.add(i);
		}
        Random indexRan=new Random();
        for (int i = 0; i < shuffleArray.length; i++) {
        	int randIndex=indexRan.nextInt(indexList.size());
			shuffleArray[i]=originArray[indexList.get(randIndex)];
			indexList.remove(randIndex);
		}
        return shuffleArray;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
