package com.interview.AddDigits;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime?
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addDigits(524356));
	}
	
public static int addDigits(int num) {
		int tmpNumber=num;
		while(tmpNumber/10 != 0)
		{
			tmpNumber=calculateNumberSum(tmpNumber);
		}
        return tmpNumber;
    }

public static int calculateNumberSum(int num){
	List<Integer> numList=new ArrayList<Integer>();
	int tmp=num;
	while(tmp/10>0){
		numList.add(tmp % 10);
		tmp=tmp/10;
	}
	numList.add(tmp);
	
	int total=0;
	for(int i:numList)
	{
		total=total+i;
	}
	
	return total;
}
}
