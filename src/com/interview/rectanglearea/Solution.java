package com.interview.rectanglearea;
/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
	Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
	Rectangle Area
Assume that the total area is never beyond the maximum possible value of int.
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution mySolution=new Solution();
/**
 * 
-1500000001
0
-1500000000
1
1500000000
0
1500000001
1
 */
//		System.out.println(mySolution.intersectArea(-2, -2, 2, 2, -2, -2, 2, 2));
		System.out.println(mySolution.intersectArea(-1500000001,0,-1500000000,1,1500000000,0,1500000001,1));
	}
	 public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		 
	     return 0;   
	    }
	 public int intersectArea(int A, int B, int C, int D, int E, int F, int G, int H)
	 {
		 //first check whether two rectangle is intersect
		 int smallistX=smallestX(A,B,C,D,E,F,G,H);
		 int smallistY=smallestY(A,B,C,D,E,F,G,H);
		 int maxX=maximumX(A, B, C, D, E, F, G, H);
		 int maxY=maximumY(A, B, C, D, E, F, G, H);
		 int rec1length=C-A;
		 int rec1height=D-B;
		 int rec2length=G-E;
		 int rec2height=H-F;
		 long maxWidth=(long)maxX-(long)smallistX;
		 long maxHeight=(long)maxY-(long)smallistY;
		 if((maxWidth<rec1length+rec2length) && (maxHeight)<rec1height+rec2height)
		 {
			 System.out.println("two rec is intersect");
			 //calculate the intersect area
			 int intersectlength=rec1length+rec2length-(maxX-smallistX);
			 int intersectheight=rec1height+rec2height-(maxY-smallistY);
			 return rec1length*rec1height + rec2length*rec2height - intersectlength*intersectheight;
		 }
		 else{
			 //no intersection
			 return rec1length*rec1height + rec2length*rec2height;
		 }
	 }
	 
	 public int smallestX(int A, int B, int C, int D, int E, int F, int G, int H)
	 {
		 if(A>=E)
		 {
			 return E;
		 }
		 else{
			 return A;
		 }
	 }
	 public int smallestY(int A, int B, int C, int D, int E, int F, int G, int H)
	 {
		 if(B>=F)
		 {
			 return F;
		 }
		 else{
			 return B;
		 }
	 }
	 
	 public int maximumX(int A, int B, int C, int D, int E, int F, int G, int H)
	 {
		 if(C>=G)
		 {
			 return C;
		 }
		 else{
			 return G;
		 }
	 }
	 public int maximumY(int A, int B, int C, int D, int E, int F, int G, int H)
	 {
		 if(D>=H)
		 {
			 return D;
		 }
		 else{
			 return H;
		 }
	 }
}
