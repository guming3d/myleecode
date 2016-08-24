package com.interview.findLongest;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array full of integers, can you write a method to findIterative the length of the
 * longest
 * consecutive sequence inside the array?
 *
 * @author Gu Ming
 */
public class FindLongestIntList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] testList={3,5,7,8,9,1,12,13,16,17,18,19};
		System.out.println(findLongest(testList));

	}
	public static int findLongest(int[] input)
	{
		int i=0;
		int j=0;
		int max=0;
		List subList=new ArrayList<Integer>();
		while(i<input.length)
		{
			j=i;
			while(j<=input.length-1)
			{
				if(j==input.length-1)
				{
					if(input[j]-input[j-1]==1)
					{
						subList.add(input[j]);
						break;
					}
				}
				else{
					if(input[j+1]-input[j] == 1)
					{
						j++;
						subList.add(input[j]);
					}
					else{
						subList.add(input[j]);
						break;
					}	
				}
			}
			
			if(j>i){
				i=j;
				if(subList.size()>max)
				{
					max=subList.size();
					subList.clear();
				}
			}else{
				subList.clear();
				i++;
			}
		}
		return max;
	}

}
