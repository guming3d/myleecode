package com.interview.guessnumberhigherorlower;

public class GuessGame {
public static int guess(int number)
{
	int num = 8;
	if(number == num)
	{
		return 0;
	}
	
	if(number > num)
	{
		return 1;
	}
	
	if(number < num)
	{
		return -1;
	}
	return 0;
	
}
}
