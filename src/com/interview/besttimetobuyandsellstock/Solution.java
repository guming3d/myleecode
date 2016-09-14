package com.interview.besttimetobuyandsellstock;
/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 (ie, buy one and sell one share of the stock multiple times). 
However, you may not engage in multiple transactions at the same time 
(ie, you must sell the stock before you buy again).
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		maxProfit(new int[]{3,2,3,4,1,6,7,5});
		maxProfit(new int[]{1,3,2,2,2,2,2});
	}
	 public static int maxProfit(int[] prices) {
	        if(prices.length==0 || prices.length==1)
	        {
	        	return 0;
	        }
	        if(prices.length==2)
	        {
	        	return prices[1]>prices[0]?prices[1]-prices[0]:0;
	        }
	        int buyPoint=0;
	        int sellPoint=0;
	        int pivot=0;
	        int totalGain=0;
	        
	        while(pivot<prices.length-1)
	        {
	        	//TODO:need to check the index out of range problem
	        	buyPoint=pivot;
	        	sellPoint=pivot;
	        	if(prices[pivot+1]<=prices[pivot])
	        	{
	        		pivot++;
	        		if(buyPoint<sellPoint)
	        		{
	        			totalGain+=prices[sellPoint] - prices[buyPoint];
	        		}
	        		buyPoint=pivot;
	        		sellPoint=pivot;
	        	}else{
	        		//find the next biggest number
	        		buyPoint=pivot;
	        		sellPoint=pivot;
	        		int tmpIndex=pivot+1;
		        	while(prices[tmpIndex]>=prices[pivot] && tmpIndex<prices.length)
		        	{
		        		if(tmpIndex+1==prices.length)
		        		{
		        			buyPoint=pivot;
		        			sellPoint=tmpIndex;
		        			totalGain+=prices[sellPoint] - prices[buyPoint];
		        			return totalGain;
		        		}
		        		if(prices[tmpIndex+1]<prices[tmpIndex])
		        		{
		        			//find the right most high number
		        			sellPoint=tmpIndex;
		        			totalGain+=prices[sellPoint] - prices[buyPoint];
		        			buyPoint=tmpIndex;
		        			break;
		        		}else{
		        			tmpIndex++;
		        		}
		        	}
		        	pivot=tmpIndex+1;
		        	
	        	}
	        	
	        }
	        
	        return totalGain;
	    }
}
