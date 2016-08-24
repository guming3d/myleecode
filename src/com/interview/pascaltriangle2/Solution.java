package com.interview.pascaltriangle2;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
 * @author mcgu
 *
 */
public class Solution {
	static List<List<Integer>> finalList=new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getRow(3);
	}
	
	public static List<Integer> getRow(int rowIndex) {
		finalList.clear();
		if(rowIndex==0)
		{
			List<Integer> result=new ArrayList<>();
			result.add(1);
			return result;
		}
		
		for (int i = 0; i <= rowIndex; i++) {
			List<Integer> rowList=new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				rowList.add(getNumber(i,j));
			}
			finalList.add(rowList);
		}
		
		return finalList.get(rowIndex);
    }
	
	public static int getNumber(int i, int j)
	{
		if(i==0)
		{
			return 1;
		}
		
		if(i==1)
		{
			return 1;
		}
		
		if(j==0 || j ==i)
		{
			return 1;
		}
		
		return finalList.get(i-1).get(j-1) + finalList.get(i-1).get(j);
	}
}
