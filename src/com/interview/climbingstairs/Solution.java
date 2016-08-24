package com.interview.climbingstairs;

import java.util.HashMap;
import java.util.Map;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStairs(44));
	}
	public static int climbStairs(int n) {
		if(n == 1)
		{
			return 1;
		}
		else if(n==2)
		{
			return 2;
		}
		else{
			return climbStairs(n-2) + climbStairs(n-1);
		}
        
    }
	
	public static int climbStairs2(int n) {
		
		Map<Integer, Integer> stepNumMap=new HashMap<>();
		stepNumMap.put(1, 1);
		stepNumMap.put(2, 2);
		for (int i = 3; i <= n; i++) {
			stepNumMap.put(i, stepNumMap.get(i-2)+stepNumMap.get(i-1));
		}
		
		return stepNumMap.get(n);
        
    }
}
