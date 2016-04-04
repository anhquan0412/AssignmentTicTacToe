/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeai;

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author anhqu
 */
public class Level1AI extends AI{
    
    protected ArrayList<Integer> possibleMoves = new ArrayList<>();
    protected Random rand;
    public Level1AI(Board board) {
        super(board);
        //create an array from 0 to 8
        for(int i = 0;i< board.getCol()*board.getRow(); i++)
        {
            possibleMoves.add(i);
        }
        rand = new Random();
    }

    @Override
    public int[] move() {
        int row,col;
        do{
            //generate random index in possibleMoves, then get the object from that index
            int r = possibleMoves.get(rand.nextInt(possibleMoves.size()));
            
            possibleMoves.remove((Object)r);
            
            //little trick to get row and column
            row = r/board.getCol(); 
            col = r%board.getCol();
            StringBuffer[] slots = board.getSlots();
            if(slots[row].charAt(col)== '_') //if the slot is empty
            {
                int[] result = {row,col};
                return result;
            }
        }
        while(true);
    }
    
}
