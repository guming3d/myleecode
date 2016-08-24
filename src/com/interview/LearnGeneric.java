package com.interview;

import java.util.ArrayList;
import java.util.List;

public class LearnGeneric {
	static String myName;
	public @interface InitVar {}
	public @interface InitVar1 {
		String myName();
	}
	
	public @interface InitVar2 {
		String myName();
		int myAge() default 20;
	}
	
	@InitVar2(myName="George")
	public static void testAnotate(){
		System.out.println("===>"+myName);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KickAssImp my001= new KickAssImp();
		KickAssImp my002= new KickAssImp();
		KickAssImp my003= new KickAssImp();
		KickAssImp my004= new KickAssNew();
		List<KickAssImp> mylist=new ArrayList<>();
		mylist.add(my001);
		mylist.add(my002);
		mylist.add(my003);
		mylist.add(my004);
		MyList.mykick(mylist);
		testAnotate();
		
	}
	

}
