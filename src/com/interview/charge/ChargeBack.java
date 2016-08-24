package com.interview.charge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 模拟自助缴费机找钱程序
 * @author mcgu
 * @date 20160802
 *
 */
public class ChargeBack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=2345;
		String binaryNumber = Integer.toString(n);
		System.out.println(binaryNumber);
		//chargeBack(2000,3000);

	}

	public static void chargeBack(int input, int charge) 
	{
		int[] result;
		Integer[] money={100,50,20,10,5,1};
		//List<Integer> mytest=Arrays.asList(100,50,20,10,5,1);
		List<Integer> moneyList=Arrays.asList(100,50,20,10,5,1);
		
		
		if(input < charge)
		{
			System.out.println("Need insert more money!!!!!");
		}
		/**
		 * Using algorithm that using larger money output possible
		 */
		int returnBack=input - charge;
		
		for(int i=0;i<moneyList.size();i++)
		{
			if(returnBack == (int)moneyList.get(i))
			{
				System.out.println("return money is "+(int)moneyList.get(i));
				break;
			}
			else if(returnBack > (int)moneyList.get(i))
			{
				int moneyNumber=returnBack/(int)moneyList.get(i);
				System.out.println(String.format("return money %d x %d", moneyNumber,(int)moneyList.get(i)));
				if((returnBack % (int)moneyList.get(i))==0)
				{
					break;
				}
				else{
					returnBack=(returnBack % (int)moneyList.get(i));
					continue;
				}
			}
		}
		
		
		return ;
	}
	
}
