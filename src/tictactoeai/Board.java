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
    private StringBuffer[] slots;
    private int row;
    private int col;
    
    public int currentRow;
    public int currentCol;
    
    public Board(int row, int col) throws Exception
    {
        if(row == col)
        {
            this.row = row;
            this.col = col;
            slots = new StringBuffer[row];
            for (int i = 0; i < row; i++) {
                slots[i] = new StringBuffer();
                for (int j = 0; j < col; j++) {
                    slots[i].append('_');
                }
            }
        }
        else
            throw new Exception("Must be a square board");
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
        char[] temp = {x,x,x};
        
        StringBuffer tempString = new StringBuffer();
        for(int i = 0;i<row;i++)
        {
            if(slots[i].indexOf(temp.toString())!=-1)
                return true;
        }
        
        //check each column, can work with nxn board
        for(int i = 0;i<col; i++)
        {
            tempString.setLength(0);
            for(int j = 0; j<col; j++)
            {
                tempString.append(slots[i].charAt(j));
            }
            if(tempString.indexOf(temp.toString())!=-1)
                return true;
        }
        
        //check diagonal, for now, just stick to 3x3
        if(slots[0].charAt(0) == x && slots[1].charAt(1) == x && slots[2].charAt(2) == x)
            return true;
        if(slots[0].charAt(2) == x && slots[1].charAt(1) == x && slots[2].charAt(0) == x)
            return true;
        
        return false;
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
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("| " + slots[i].charAt(j) + " ");  
            }
            System.out.println("|");
        }
    }
}
