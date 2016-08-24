package com.interview.rangesumquery;
/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
 * @author mcgu
 *
 */
public class NumArray {

	int[] myArray=new int[]{};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumArray testarray=new NumArray(new int[]{});
		System.out.println(testarray.sumRange(0, 0));
	}
	public NumArray(int[] nums) {
        myArray=nums;
    }

    public int sumRange(int i, int j) {
        if(myArray.length==0)
        {
        	return 0;
        }
        if(i>myArray.length-1)
        {
        	return 0;
        }
        int finalResult=0;
        if(i==j)
        {
        	finalResult=myArray[i];
        	return finalResult;
        }
		else {
			for (int k = i; k <= (j>myArray.length-1?myArray.length-1:j); k++) {
				finalResult += myArray[k];
			}
			return finalResult;
		}
        
    }
}
//Your NumArray object will be instantiated and called as such:
//NumArray numArray = new NumArray(nums);
//numArray.sumRange(0, 1);
//numArray.sumRange(1, 2);