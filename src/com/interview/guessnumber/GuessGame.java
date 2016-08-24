package com.interview.guessnumber;
/**
 *  -1 if my number is lower, 1 if my number is higher, otherwise return 0
 * @author guming
 *
 */
public class GuessGame {
	public int guess(int num){
		int result=3;
		if(num>result)
		{
			return -1;
		}else if(num<result){
			return 1;
		}else{
			return 0;
		}
	}
}
