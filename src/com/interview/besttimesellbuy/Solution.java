package com.interview.besttimesellbuy;
/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.
 * @author mcgu
 *
 */
public class Solution {
	static int
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] testData={7, 1, 5, 3, 6, 4};
		System.out.println(maxProfit2(testData));
	}
	public static int maxProfit(int[] prices) {
		int maximumsell=0;
		for (int i = 0; i < prices.length; i++) {
			for (int j = i+1; j < prices.length; j++) {
				if(prices[j]-prices[i]>maximumsell)
				{
					maximumsell=prices[j]-prices[i];
				}
			}
		}
        return maximumsell;
    }
	
	public static int maxProfit2(int[] prices) {

		if(prices.length<=1)
		{
			return 0;
		}
		
		int curMin=prices[0];
		int maxDiff=0;
		for (int i = 0; i < prices.length; i++) {
			curMin=Math.min(prices[i], curMin);
			maxDiff=Math.max(maxDiff, prices[i]-curMin);
		}
        return maxDiff;
    }
	
	public static int maxNumber(int[] prices,int start,int end)
	{
		int maxNumber=prices[start];
		int maxIndex=-1;
		for (int i = start; i <= end; i++) {
			if(prices[i]>maxNumber)
			{
				maxNumber=prices[i];
				maxIndex=i;
			}
		}
		return maxIndex;
	}
	public static int minNumber(int[] prices,int start,int end)
	{
		int minNumber=prices[start];
		int minIndex=-1;
		for (int i = start; i <= end; i++) {
			if(prices[i]<minNumber)
			{
				minNumber=prices[i];
				minIndex=i;
			}
		}
		return minIndex;
	}
}
