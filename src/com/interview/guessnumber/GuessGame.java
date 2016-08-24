package com.interview.guessnumber;

public class GuessGame {
	public int guess(int num)
	{
		final int right=6;
		if(num > right)
		{
			return 1;
		}else if(num < right)
		{
			return -1;
		}else if(num ==right)
		{
			return 0;
		}
		return 0;
	}
}
