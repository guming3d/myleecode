package com.interview.addbinary;
/**
 * Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    System.out.println(addBinary("0","0"));
	}
	public static String addBinary(String a, String b) {
		boolean needIncrease=false;
		int lengthStr1=a.length();
		int lengthStr2=b.length();
		int rightLength=(lengthStr1>lengthStr2) ? lengthStr2:lengthStr1;
		int index1=a.length()-1;
		int index2=b.length()-1;
		String finalString ="";
		while(index1>=0 && index2>=0)
		{
			if(needIncrease==false)
			{
				if(a.charAt(index1)=='1' && b.charAt(index2)=='1')
				{
					needIncrease=true;
					finalString='0'+finalString;
				}else if((a.charAt(index1)=='1' && b.charAt(index2)=='0') ||(a.charAt(index1)=='0' && b.charAt(index2)=='1')){
					needIncrease=false;
					finalString='1'+finalString;
				}else {
					needIncrease=false;
					finalString='0'+finalString;
				}
				
			}
			else{
				if(a.charAt(index1)=='1' && b.charAt(index2)=='1')
				{
					needIncrease=true;
					finalString='1'+finalString;
				}else if((a.charAt(index1)=='1' && b.charAt(index2)=='0') ||(a.charAt(index1)=='0' && b.charAt(index2)=='1')){
					needIncrease=true;
					finalString='0'+finalString;
				}else {
					needIncrease=false;
					finalString='1'+finalString;
				}
			}
			index1--;
			index2--;
		}
		
		if(index1>index2){
			while(index1>=0)
			{
				if(needIncrease==false)
				{
					finalString=a.charAt(index1)+finalString;
				}else{
					if(a.charAt(index1)=='1')
					{
						needIncrease=true;
						finalString='0'+finalString;
					}
					else{
						needIncrease=false;
						finalString='1'+finalString;
					}
				}
				index1--;
			}
			if(needIncrease==true)
			{
				finalString='1'+finalString;
			}
		}else if(index1<index2){
			while(index2>=0)
			{
				if(needIncrease==false)
				{
					finalString=b.charAt(index2)+finalString;
				}else{
					if(b.charAt(index2)=='1')
					{
						needIncrease=true;
						finalString='0'+finalString;
					}
					else{
						needIncrease=false;
						finalString='1'+finalString;
					}
				}
				index2--;
			}
			if(needIncrease==true)
			{
				finalString='1'+finalString;
			}
		}else{
			//two string are equal length
			if(needIncrease==true)
			{
				finalString='1'+finalString;
			}
		}
		return finalString;
    }
}
