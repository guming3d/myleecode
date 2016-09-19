package com.interview.pow;

/**
 * 50. Pow(x, n)
 * 
 * Total Accepted: 108543 Total Submissions: 395917 Difficulty: Medium
 * 
 * Implement pow(x, n).
 * 
 * Subscribe to see which companies asked this questio
 * 
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution mySolution=new Solution();
		System.out.println(mySolution.myPow(0.444, -5));
	}

    //NOT FINISHED!!!!!!!
	public double myPow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}
		
		if(x==0)
		{
			if(n>=0)
			{
				return 1;
			}else{
				return Double.POSITIVE_INFINITY;
			}
		}
		if(x==1)
		{
			return 1;
		}
		
		if(x>1)
		{
			//Double.isFinite(arg0)
			double result = 1;
			if(n>0)
			{
				for (int i = 1; i <= n; i++) {

					if((result*x)>Double.MAX_VALUE)
					{
						return Double.MAX_VALUE;
					}else{
						result = result * x;	
					}
				}
				return result;
			}else if(n<0){
				int m=n* (-1);
				for (int i = 1; i <= m; i++) {
					if((result*x)>Double.MAX_VALUE)
					{
						return Double.POSITIVE_INFINITY;
					}else{
						result = result * x;	
					}
					
					
				}
				return 1/result;
			}else{
				return 1;
			}
		}
		
		if(x>0 && x<1)
		{
			double result = 1;
			if(n>0)
			{
				
				for (int i = 1; i <= n; i++) {

					if((result*x)<Double.POSITIVE_INFINITY)
					{
						return Double.POSITIVE_INFINITY;
					}else{
						result = result * x;	
					}
				}
				return result;
			}else{
				int m=n* (-1);
				for (int i = 1; i <= m; i++) {

					if((result*x)<Double.POSITIVE_INFINITY)
					{
						result= Double.POSITIVE_INFINITY;
						break;
					}else{
						result = result * x;	
					}
				}
				if (result==Double.POSITIVE_INFINITY)
				{
					return Double.MAX_VALUE;
				}
				return 1/result;
			}
		}
		
		
		if(x>-1 && x<0)
		{
			double result = 1;
			if(n>0)
			{
				if(n % 2==0)
				{
					int absX=(int)Math.abs(x);
					for (int i = 1; i <= n; i++) {

						if((result*absX)<Double.POSITIVE_INFINITY)
						{
							return Double.POSITIVE_INFINITY;
						}else{
							result = result * absX;	
						}
					}
					return result;
				}else{
					int absX=(int)Math.abs(x);
					for (int i = 1; i <= n; i++) {

						if((result*absX)<Double.POSITIVE_INFINITY)
						{
							return Double.NEGATIVE_INFINITY;
						}else{
							result = result * absX;	
						}
					}
					return 0-result;
				}
				
			}else{
				if(n % 2==0)
				{
					int absX=(int)Math.abs(x);
					int absN=(int)Math.abs(n);
					for (int i = 1; i <= absN; i++) {

						if((result*absX)<Double.POSITIVE_INFINITY)
						{
							return Double.MAX_VALUE;
						}else{
							result = result * absX;	
						}
					}
					return result;
				}else{
					int absX=(int)Math.abs(x);
					int absN=(int)Math.abs(n);
					for (int i = 1; i <= absN; i++) {

						if((result*absX)<Double.POSITIVE_INFINITY)
						{
							return Double.MIN_VALUE;
						}else{
							result = result * absX;	
						}
					}
					return 1/result;
				}
			}
		}
		
		if(x<-1)
		{
			//Double.isFinite(arg0)
			double result = 1;
			if(n>0)
			{
				if(n % 2==0)
				{
					int absX=(int)Math.abs(x);
					for (int i = 1; i <= n; i++) {

						if((result*absX)>Double.MAX_VALUE)
						{
							return Double.MAX_VALUE;
						}else{
							result = result * absX;	
						}
					}
					return result;
				}else{
					int absX=(int)Math.abs(x);
					for (int i = 1; i <= n; i++) {

						if((result*absX)>Double.MAX_VALUE)
						{
							return Double.MIN_VALUE;
						}else{
							result = result * absX;	
						}
					}
					return 0-result;
				}
				
			}else if(n<0){
				if(n % 2 ==0)
				{
					int m=(int)Math.abs(n);
					int absX=(int)Math.abs(x);
					for (int i = 1; i <= m; i++) {
						if((result*absX)>Double.MAX_VALUE)
						{
							return Double.POSITIVE_INFINITY;
							
						}else{
							result = result * absX;	
						}
					}
					return 1/result;
				}else{
					int m=(int)Math.abs(n);
					int absX=(int)Math.abs(x);
					for (int i = 1; i <= m; i++) {
						if((result*absX)>Double.MAX_VALUE)
						{
							return Double.MIN_VALUE;
						}else{
							result = result * absX;	
						}
						
						
					}
					return 0-(1/result);
				}
				
			}else{
				return 1;
			}
		}
		
		
		
		
		//Double.isFinite(arg0)
		double result = 1;
		int m = n >= 0 ? n : (n * -1);
		for (int i = 1; i <= m; i++) {

			result = result * x;
			
		}
		if (n < 0) {
			return 1 / result;
		} else {
			return result;
		}
	}
}
