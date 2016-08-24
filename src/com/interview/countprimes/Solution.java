package com.interview.countprimes;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:

Count the number of prime numbers less than a non-negative number, n.
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countPrimes3(4000);
	}
	//Performance is not good
	 public static int countPrimes(int n) {
		 if(n==1)
		 {
			 return 0;
		 }
		 if(n==2)
		 {
			 return 1;
		 }
		 if(n==3)
		 {
			 return 2;
		 }
		 if(n==4)
		 {
			 return 2;
		 }
		 int primeCount=2;
		 int lastPrim=3;
		 for (int i = 5; i <n ; i++) {
			 boolean isPrime=true;
			 for (int j = 2; j < i/2; j++) {
					if(i % j !=0)
					{
						continue;						
					}else{
						isPrime=false;
						break;
					}
				}
			 if(isPrime==true)
			 {
				 System.out.println("Prime number :"+i);
				 primeCount++;
			 }
		}
		 System.out.println(primeCount);
		 return primeCount;
	    }
	 
	 public static int countPrimes2(int n) {
		 if(n==0)
		 {
			 return 0;
		 }
		 if(n==1)
		 {
			 return 0;
		 }
		 if(n==2)
		 {
			 return 0;
		 }
		 if(n==3)
		 {
			 return 1;
		 }
		 if(n==4)
		 {
			 return 2;
		 }
		 int primeCount=2;
		 //int[] primArray=new int[]{2,3};
		 List<Integer> primList=new ArrayList<>();
		 primList.add(2);
		 primList.add(3);
		 
		 for (int i = 5; i <n ; i++) {
			 boolean isPrime=true;
			 int rightMostNumber=i % 10;
			 if(rightMostNumber==0)
			 {
				 continue;
			 }
			 if(rightMostNumber % 2 == 0)
			 {
				 continue;
			 }
			 if(rightMostNumber % 5 == 0)
			 {
				 continue;
			 }
			 
			 for (int j = 0; j < primList.size(); j++) {
				if(i % primList.get(j) !=0)
				{
					continue;
				}else{
					isPrime=false;
					break;
				}
			}
			 if(isPrime==true)
			 {
				 primList.add(i);
				 //System.out.println("Prime number :"+i);
				 primeCount++;
			 }
		}
		 System.out.println(primeCount);
		 return primeCount;
	    }
	 //Using array instead of list to increase performance
	 public static int countPrimes3(int n) {
		 if(n==0)
		 {
			 return 0;
		 }
		 if(n==1)
		 {
			 return 0;
		 }
		 if(n==2)
		 {
			 return 0;
		 }
		 if(n==3)
		 {
			 return 1;
		 }
		 if(n==4)
		 {
			 return 2;
		 }
		 if(n==5)
		 {
			 return 2;
		 }
		 int primeCount=3;
		 //int[] primArray=new int[]{2,3};
		 int[] primArr=new int[n];
		 primArr[0]=2;
		 primArr[1]=3;
		 primArr[2]=5;
		 
//		 List<Integer> primList=new ArrayList<>();
//		 primList.add(2);
//		 primList.add(3);
		 
		 for (int i = 6; i <n ; i++) 
		 {
			 boolean isPrime=true;
			 int rightMostNumber=i % 10;
			 
			 if(rightMostNumber % 2 == 0 || rightMostNumber % 5 == 0 || rightMostNumber==0)
			 {
				 continue;
			 }

             int leftPrimMax=i;
			 for (int j = 0; j < primeCount; j++) {
			     
			     if(primArr[j]>leftPrimMax)
			     {
			         break;
			     }
			     
				if(i % primArr[j] !=0)
				{
					leftPrimMax=i / primArr[j];
					continue;
				}else{
					isPrime=false;
					break;
				}
				
			}
			 if(isPrime==true)
			 {
//				 primList.add(i);
				 primArr[primeCount]=i;
				 //System.out.println("Prime number :"+i);
				 primeCount++;
			 }
		}
		 System.out.println(primeCount);
		 return primeCount;
	    }
}
