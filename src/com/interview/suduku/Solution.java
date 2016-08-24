package com.interview.suduku;

import java.util.HashMap;
import java.util.Map;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 * @author mcgu
 * TODO consider char not number
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] testBoard={
				{'.','8','7','6','5','4','3','2','1' },
				{'2','.','.','.','.','.','.','.','.' },
				{'3','.','.','.','.','.','.','.','.' },
				{'4','.','.','.','.','.','.','.','.' },
				{'5','.','.','.','.','.','.','.','.' },
				{'6','.','.','.','.','.','.','.','.' },
				{'7','.','.','.','.','.','.','.','.' },
				{'8','.','.','.','.','.','.','.','.' },
				{'9','.','.','.','.','.','.','.','.' }
				
		};
		System.out.println(isValidSudoku(testBoard));
	}
    public static boolean isValidSudoku(char[][] board) {
    	Map<Character, Integer> resultMap=new HashMap<>();
    	//check the line is valid
    	for (int i = 0; i < board.length; i++) 
    	{
    		resultMap.clear();
			for (int j = 0; j < board[i].length; j++) {
				if(!resultMap.containsKey(board[i][j]))
				{
					if(board[i][j] !='.')
					{
						resultMap.put(board[i][j], 1);	
					}
					
				}else
				{
					System.out.println("Number "+board[i][j]+" already exist in line "+i);
					return false;
				}
			}
		}
    	
    	//check the vertic is valid
    	for (int i = 0; i < board[0].length; i++) 
    	{
    		resultMap.clear();
			for (int j = 0; j < board.length; j++) {
				if(!resultMap.containsKey(board[j][i]))
				{
					if(board[j][i] !='.')
					{
						resultMap.put(board[j][i], 1);	
					}
				}else
				{
					System.out.println("Number "+board[j][i]+" already exist in vertex "+i);
					return false;
				}
			}
		}
    	
    	//check the rectangle is valid
    	for (int i = 0; i < board.length-2; i=i+3) {
    		for (int j = 0; j < board.length-2; j=j+3) {
				if(!isRecValid(i, j, board))
				{
					return false;
				}
			}
			
		}
    	
        return true;
    }
    
    //Check the rectangle
    public static boolean isRecValid(int line,int vertex, char[][] board)
    {
    	Map<Character, Integer> resultMap=new HashMap<>();
    	
    	for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if( !resultMap.containsKey(board[line+i][vertex+j]))
				{
					if(board[line+i][vertex+j] !='.')
					{
						resultMap.put(board[line+i][vertex+j], 1);	
					}
				}else
				{
					System.out.println("Number "+board[line+i][vertex+j]+" already exist in rec started at ["+(i+line)+"]"+"["+(j+vertex)+"]");
					return false;
				}
			}
		}
    	return true;
    }
    
    public static boolean isValidNum(char i)
    {
    	if(i=='.')
    	{
    		return true;
    	}else if(i>='1' && i<='9')
    	{
    		return true;
    	}else{
    		return false;	
    	}
    	
    }
}
