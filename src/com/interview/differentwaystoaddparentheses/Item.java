package com.interview.differentwaystoaddparentheses;

public class Item{
	private int number;
	private char operation;
	public boolean isNumber=false;
	public int getNumber(){
		return number;
	}
	public Item(int num)
	{
		this.number=num;
		this.isNumber=true;
	}
	public Item(char oper)
	{
		this.operation=oper;
		this.isNumber=false;
	}
	public char getOperation()
	{
		return operation;
	}
	public void setNumber(int num){
		this.number=num;
	}
	public void setOperation(char oper)
	{
		this.operation=oper;
	}
	
}