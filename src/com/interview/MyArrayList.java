package com.interview;

import java.util.Iterator;

import oracle.jrockit.jfr.jdkevents.ThrowableTracer;

public class MyArrayList<AnyType> implements Iterable<AnyType> {

	private int theSize;
	private AnyType [] theItems;
	
	@Override
	public Iterator<AnyType> iterator() {
		// TODO Auto-generated method stub
		return new ArrayListIterator();
	}
	
	private int size(){
		return theItems.length;
	}
	
	private void remove(int index)
	{
		theItems[index]=null;
	}
	
	private class ArrayListIterator implements Iterator<AnyType>
	{
		private int current = 0 ;
		public boolean hasNext(){
			return current < size();
		}
		public AnyType next(){
			return theItems[current++];
		}
		public void remove()
		{
			MyArrayList.this.remove(--current);
		}
	}
	
	public static void main(String[] args) {
		MyArrayList myList=new MyArrayList<String>();
		
		myList.forEach(System.out::println);
	}
	
}
