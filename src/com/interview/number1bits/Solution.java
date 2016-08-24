package com.interview.number1bits;
/**
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.
 * @author mcgu
 * TODO:
 */
@Deprecated
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long test=5;
		hammingWeight(5);
	}
	// you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
    	int bits=0;
    	int masks=1;
    	for (int i = 0; i < 32; i++) {
			if( (n & masks) == 1)
			{
				bits++;
			}
			n>>=1;
		}
    	System.out.println(bits);
        return bits;
    }
}
