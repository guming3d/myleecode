package com.interview.guessnumberhigherorlower;
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

 The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); 

 * @author guming
 *
 */
public class Solution extends GuessGame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(guessNumber(99));
	}
	public static int guessNumber(int n) {
        int lowNumber,highNumber;
        lowNumber=1;
        highNumber=n;
        
        if(n==1)
        {
            return n;
        }
        
        int tmpGuessNum=0;
        while((tmpGuessNum=guess((lowNumber+highNumber)/2))!=0)
        {
            if(tmpGuessNum==-1)
            {
                lowNumber=(lowNumber+highNumber)/2;
            }else if(tmpGuessNum==1)
            {
                highNumber=(lowNumber+highNumber)/2;
            }
            
            if(lowNumber==highNumber)
            {
                return lowNumber;
            }
            
        }
//        System.out.println("");
        return (lowNumber+highNumber)/2;
    }
}
