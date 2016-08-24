package com.interview.countingbits;
/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num 
 * calculate the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

    It is very easy to come up with a solution with run time O(n*sizeof(integer)). 
    But can you do it in linear time O(n) /possibly in a single pass?
    Space complexity should be O(n).
    Can you do it like a boss? Do it without using any builtin function like __builtin_popcount 
    in c++ or in any other language.

 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countBits(8);
	}
	public static int[] countBits(int num) {
		int[] bitNumArray=new int[num+1];
		if(num==0)
		{
			return new int[]{0};
		}
		if(num==1)
		{
			return new int[]{0,1};
		}
		if(num==2)
		{
			return new int[]{0,1,1};
		}
		bitNumArray[0]=0;
		bitNumArray[1]=1;
		bitNumArray[2]=1;
		for (int i = 3; i < bitNumArray.length; i++) {
			if((i-1) % 2 == 0)
			{
				bitNumArray[i]=bitNumArray[i-1] +1;
			}else{
				//calculate the number of bit 1 in right most of prev number
				int bit1Num=0;
				int tmp=i-1;
				while((tmp & 1)==1)
				{
					tmp=tmp>>1;
					bit1Num++;
				}
				bitNumArray[i]=bitNumArray[i-1]-bit1Num+1;
			}
		}
		
        return bitNumArray;
    }
}
