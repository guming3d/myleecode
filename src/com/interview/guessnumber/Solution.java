package com.interview.guessnumber;

public class Solution extends GuessGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution mySolution=new Solution();
		System.out.println(mySolution.guessNumber(5));
	}
	public  int guessNumber(int n) {
        if(n==1)
        {
            return 1;
        }
        if(n==2)
        {
        	if(guess(1)==0)
        	{
        		return 1;
        	}else{
        		return 2;
        	}
        }
        int lowNumber,highNumber;
        lowNumber=1;
        highNumber=n;
 
        int tmpGuessNum=0;
        int middle=lowNumber + (highNumber - lowNumber)/2;
        while((tmpGuessNum=guess(middle))!=0)
        {
            if(tmpGuessNum==-1)
            {
            	if(highNumber==middle)
            	{
            		highNumber=middle-1;
            	}else{
            		highNumber=middle;	
            	}
            	
            }else if(tmpGuessNum==1)
            {
            	if(lowNumber==middle)
            	{
            		lowNumber=middle+1;
            	}else{
            		lowNumber=middle;	
            	}
                
            }
            
            if(lowNumber==highNumber)
            {
                return lowNumber;
            }
            middle=lowNumber + (highNumber - lowNumber)/2;
        }
//        System.out.println("");
        return middle;
    }
}
