package com.interview.guessnumber;

import java.util.Random;
import java.util.RandomAccess;

/**
 * We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
Example:
n = 10, I pick 6.

Return 6.
 * @author mcgu
 *
 */

/*
 * TODO: NOT FINISHED
 */
public class Solution extends GuessGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution mysolution=new Solution();
		int internalResult=mysolution.guessNumber(10);
		System.out.println(internalResult);
	}
	
	public  int guessNumber(int n) {
		if(n==1)
		{
			return 1;
		}
		int start=1;
		int end=n;
		int middle=1 + (n-1)/2;
		int tmp;
		while((tmp=guess(middle))!=0)
		{
			if(tmp>0)
			{
				end=middle;
			}else{
				start=middle;
			}
			middle=start + (end-start)/2;
		}
		return middle;
        
    }
}
