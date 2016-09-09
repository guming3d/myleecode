package com.interview.bulbswitcher;
/**
 *  There are n bulbs that are initially off. You first turn on all the bulbs. 
 *  Then, you turn off every second bulb. On the third round, you toggle every
 *   third bulb (turning on if it's off or turning off if it's on). For the ith round, 
 *   you toggle every i bulb. For the nth round, you only toggle the last bulb. 
 *   Find how many bulbs are on after n rounds.

Example:

Given n = 3. 

At first, the three bulbs are [off, off, off].
After first round, the three bulbs are [on, on, on].
After second round, the three bulbs are [on, off, on].
After third round, the three bulbs are [on, off, off]. 

So you should return 1, because there is only one bulb is on.

 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(bulbSwitch2(12));
	}
	 public static int bulbSwitch(int n) {
		 int[] oneNumber=new int[n+1];
		 
		 
		 if(n==0)
		 {
			
			 return 0;
		 }
		 oneNumber[n]=0;
		 oneNumber[0]=0;
		 if(n==1)
		 {
			
			 return 1;
		 }
		 oneNumber[1]=1;
		 oneNumber[n]=1;
		 if(n==2)
		 {
			
			 return 1;
		 }
		 oneNumber[2]=1;
		 
		 if(n % 2 ==0)
		 {
			 oneNumber[n]=oneNumber[n]==0?1:0;
		 }
		 
		 if(n==3)
		 {
			 
			 return 1;
		 }
		 
		 if(n % 3 ==0)
		 {
			 oneNumber[n]=oneNumber[n]==0?1:0;	 
		 }
		 
		 oneNumber[3]=1;
		 int totalDivNumber=0;
		 for(int i=4;i<=n;i++)
		 {
			 totalDivNumber=0;
			 for(int j=2;j<=i/2;j++)
			 {
				 if((i/j) * j==i)
				 {
					 //n can be divided by j
					 totalDivNumber++;
				 }
			 }
			 if(totalDivNumber==0)
			 {
				 oneNumber[i]=oneNumber[i-1];
			 }else{
				 if(totalDivNumber % 2 == 1)
				 {
					 oneNumber[i]=oneNumber[i-1]+1; 
				 }else{
					 oneNumber[i]=oneNumber[i-1];
				 }
			 }
			 
		 }
		 
		 
		 
	        return oneNumber[n];
	    }
	 public static int bulbSwitch2(int n) {
		 int[] oneNumber=new int[n+1];
		 
		 
		 if(n==0)
		 {
			
			 return 0;
		 }
		 oneNumber[n]=0;
		 oneNumber[0]=0;
		 if(n==1)
		 {
			
			 return 1;
		 }
		 oneNumber[1]=1;
		 oneNumber[n]=1;
		 if(n==2)
		 {
			
			 return 1;
		 }
		 oneNumber[2]=1;
		 
		 if(n % 2 ==0)
		 {
			 oneNumber[n]=oneNumber[n]==0?1:0;
		 }
		 
		 if(n==3)
		 {
			 
			 return 1;
		 }
		 
		 if(n % 3 ==0)
		 {
			 oneNumber[n]=oneNumber[n]==0?1:0;	 
		 }
		 
		 oneNumber[3]=1;
		 int totalDivNumber=0;
		 for(int i=4;i<=n;i++)
		 {
			 totalDivNumber=0;
			 if(n/i * i == n)
			 {
				 
			 }
			 if(totalDivNumber==0)
			 {
				 oneNumber[i]=oneNumber[i-1];
			 }else{
				 if(totalDivNumber % 2 == 1)
				 {
					 oneNumber[i]=oneNumber[i-1]+1; 
				 }else{
					 oneNumber[i]=oneNumber[i-1];
				 }
			 }
			 
		 }
		 
		 
		 
	        return oneNumber[n];
	    }
}
