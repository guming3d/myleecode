package com.interview.reversebits;

import com.sun.javafx.fxml.expression.BinaryExpression;

/**
 * Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?

Related problem: Reverse Integer
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverseBits(12);
	}
	// you need treat n as an unsigned value
    public static int reverseBits(int n) {
//    	int i=0B110111;
//    	System.out.println(Integer.toBinaryString(i));
    	int tmp=n;
    	int index=0;
    	while(tmp/2>0)
    	{
    		System.out.println(index+"->"+tmp % 2);
    		tmp/=2;
    		index++;
    	}
    	System.out.print(index+"->"+tmp % 2);
    	
    	System.out.print("-------------");
    	//
    	int reverseBits=0;
    	for (int i = 0; i < 32; i++) {
    		int currBit=n>>i & 1;
    		reverseBits+=currBit<<(31-i);
		}
    	System.out.print(Integer.toBinaryString(reverseBits));
    	return reverseBits;
    	
    }
}
