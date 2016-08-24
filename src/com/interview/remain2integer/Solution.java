package com.interview.remain2integer;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
Ⅰ（1）Ⅴ（5）Ⅹ（10）L（50）C（100）D（500）M（1000） 
 * @author mcgu
 *
 */

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int romanToInt(String s) {
		final Map<Character,Integer> romamNumerList=new HashMap<>();
		romamNumerList.put('I', 1);
		romamNumerList.put('V', 5);
		romamNumerList.put('X', 10);
		romamNumerList.put('L', 50);
		romamNumerList.put('C', 100);
		romamNumerList.put('D', 500);
		romamNumerList.put('M', 1000);
		
		String finalString=s.toUpperCase();
		int totalNumer = 0;
		Stack<Integer> tmpStack=new Stack<>();
		for (int i = 0; i < finalString.length()-1; i++) {
			
			if(romamNumerList.get(finalString.charAt(i+1)) > 
			   romamNumerList.get(finalString.charAt(i))){
				/* right side is larger */
				tmpStack.push(romamNumerList.get(finalString.charAt(i)));
			}
			else{
				totalNumer+=romamNumerList.get(finalString.charAt(i+1));
			}
			if(tmpStack.isEmpty())
			{
				
			}
		}
		if(!tmpStack.isEmpty())
		{
			int totalInStack=0;
			for(Integer i:tmpStack)
			{
				totalInStack+=i;
			}
			totalNumer+=romamNumerList.get(finalString.charAt(finalString.length()-1))-totalInStack;
		}
        return 0;
    }
}
