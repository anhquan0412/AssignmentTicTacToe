/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeai;

import java.text.ParseException;
/**
 *
 * @author anhqu
 */
public class Board {
	//Slots is a representation of each row.
    private StringBuffer[] slots;
    private int row;
    private int col;
    private StringBuffer label;
    
    public int currentRow;
    public int currentCol;
    
    //Since it has to be square by definition, why initialize with two variables?
    public Board(int size)
    {
            this.row = size;
            this.col = size;
            label = new StringBuffer("  ");
            slots = new StringBuffer[row];
            for (int i = 0; i < row; i++) {
                slots[i] = new StringBuffer();
                for (int j = 0; j < col; j++) {
                    slots[i].append('_');
                }
            }
            for (int i = 0; i < size; i++){
            	label.append(i+1);
            	label.append(' ');
            }
        
    }
    
    
    public void clearBoard()
    {
        for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    slots[i].setCharAt(j, '_');
                }
            }
    }
    
    public StringBuffer[] getSlots()
    {
        return slots;
    }
    
    public boolean setMove(int x, int y, char c)
    {
        if (x >= 0 && x < row && y >= 0 && y < col
               && slots[x].charAt(y) == '_' ) {
            slots[x].setCharAt(y, c);
            return true;
        }
        System.out.println("Invalid move");
        return false;
        
    }
    public int getRow()
    {
        return row;
    }
    public int getCol()
    {
        return col;
    }
    
    public boolean hasWon(char x)
    {
        //check each row, can work with nxn board
        //char[] temp = {x,x,x};
        //StringBuffer tempString = new StringBuffer();
        for(int i = 0;i<row;i++)
        {
           // if(slots[i].indexOf(temp.toString())!=-1)
                //return true;
        	//Check the board. If an entire row is the same character, return true
        	for(int j = 0; j < col; j++){
        		if(slots[i].charAt(j) != x)
        			break;
        		if( j == col - 1){
        			return true;
        		}
        	}
        }
        
        //check each column, can work with nxn board
        //Iterate through each column, if any element of the column is not x, go to the next
        //Column, if you make it to the last element of a column, everything must be x.
        for(int i = 0;i<col; i++)
        {
            //tempString.setLength(0);
            for(int j = 0; j<row; j++)
            {
                //tempString.append(slots[i].charAt(j));
            	if(slots[j].charAt(i) != x)
            		break;
            	if (j == row - 1)
            		return true;
            }
            //if(tempString.indexOf(temp.toString())!=-1)
                //return true;
        }
        //Booleans diag1 and diag2 are initialized to true. Then check both diagonals,
        //if any character on either diagonal is not x, then the boolean is set to false.
        //If either diagonal holds true, then the game has been won.
        boolean diag1 = true, diag2 = true;
        //check diagonal, for now, just stick to 3x3
        for(int i = 0; i < slots.length; i++){
        	if (slots[i].charAt(i) != x)
        		diag1 = false;
        	if (slots[i].charAt(slots.length - i - 1) != x)
        		diag2 = false;
        	if (!diag1 && !diag2)
        		break;
        }
        
        
		return (diag1 || diag2);
    }
    
    public boolean isDraw()
    {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(slots[i].charAt(j)== '_')
                    return false;
            }
        }
        return true;
    }
    public void paint()
    {
    	System.out.println(label);
        for (int i = 0; i < row; i++) {
        	System.out.print(i + 1);
            for (int j = 0; j < col; j++) {
                System.out.print("|" + slots[i].charAt(j) + "");  
            }
            System.out.println("|");
        }
    }
}
