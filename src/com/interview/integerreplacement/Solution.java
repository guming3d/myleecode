package com.interview.integerreplacement;

import java.util.HashMap;
import java.util.Map;

/**
 * 397. Integer Replacement

    Total Accepted: 1728
    Total Submissions: 7217
    Difficulty: Easy

Given a positive integer n and you can do operations as follow:

    If n is even, replace n with n/2.
    If n is odd, you can replace n with either n + 1 or n - 1.

What is the minimum number of replacements needed for n to become 1?

Example 1:

Input:
8

Output:
3

Explanation:
8 -> 4 -> 2 -> 1

Example 2:

Input:
7

Output:
4

Explanation:
7 -> 8 -> 4 -> 2 -> 1
or
7 -> 6 -> 3 -> 2 -> 1

 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution mySolution=new Solution();
		System.out.println(mySolution.integerReplacement2(2147483647));
	}
	//Bad performance
	public int integerReplacement(int n) {
        Map<Integer,Integer> solutionMap=new HashMap<>();
        if(n==1)
        {
            return 0;
        }
        if(n==2)
        {
            return 1;
        }
        solutionMap.put(1,0);
        solutionMap.put(2,1);
        for(int i=3;i<=n;i++)
        {
            if(i % 2 == 0)
            {
                solutionMap.put(i,solutionMap.get(i/2)+1);
            }else{
                int nextNumber=solutionMap.get((i+1)/2)+1;
                solutionMap.put(i, Math.min(solutionMap.get(i-1),nextNumber ) + 1);
            }
        }
        
        return solutionMap.get(n);
    }
	static Map<Integer,Integer> solutionMap=new HashMap<>();
	public int integerReplacement2(int n) {
		if(n==0)
		{
			solutionMap.put(0, 1);
			return 1;
		}
		if(n==1)
        {
			solutionMap.put(1, 0);
            return 0;
        }
        if(n==2)
        {
        	solutionMap.put(2, 1);
            return 1;
        }
        int result=0;
        if(solutionMap.containsKey(n))
        {
        	return solutionMap.get(n);
        }
        
        if(n % 2 == 0)
        {
        	 result=integerReplacement2(n/2) +1;
        	solutionMap.put(n, result);
        	return result;
        }else{
        	int prev=integerReplacement2(n-1);
        	int next=0;
        	if(n==Integer.MAX_VALUE)
        	{
        		next=integerReplacement2(n/2 + 1) + 1;
        	}else{
        		next=integerReplacement2(n+1);
        	}
        	 result=Math.min(prev, next) + 1;
        	solutionMap.put(n, result);
        	return result;
        }

	}
}
