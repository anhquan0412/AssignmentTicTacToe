/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeai;

/**
 *
 * @author anhqu
 */
public class Level2AI extends Level1AI {

    public Level2AI(Board b) {
        super(b);
    }

    @Override
    //First check for a winning move, if no winning move exists, do a random move
    public int[] move() {
    	int[] ret;
    	if ((ret = canWin('O')) != null)
    		return ret;
        return super.move();
    }
    
	/*Check each row to see if it is one move away from winning.Do this by treating
	 * each 'O', the AI's marker, as +1, a space as 0, and each 'X', the player's
	 * marker, as -1. If the total of any row, column, or diagonal is one less than
	 * the size of the board, then that row, column or diagonal is one space away from
	 * victory. Then determine the slot with a ' ', and submit that as the winning move.
	 * If there is no winning move, return null.
	 */
	private int[] canWin(char x) {
		int total = 0;
		
		//Check the rows, if a row can win, find the empty column, and return the pair
		for (int i = 0; i < board.getRow(); i++){
			total = 0;
			for(int j = 0; j < board.getCol(); j++){
				if(board.getSlots()[i].charAt(j) == x)
					total++;
				else if (board.getSlots()[i].charAt(j) == '_')
					continue;
				else
					total--;
			}
			if (total == board.getRow() - 1){
				for(int k = 0; i < board.getCol(); k++)
					if (board.getSlots()[i].charAt(k) == '_')
						return new int[] {i,k};
			}
		}	
			
			//Check the columns. If a column can win, find the empty row, and return the pair
			for(int i = 0; i < board.getCol(); i++){
				total = 0;
				for(int j = 0; j < board.getRow(); j++){
					if (board.getSlots()[j].charAt(i) == x)
						total++;
					else if(board.getSlots()[j].charAt(i) == '_')
						continue;
					else 
						total--;
				}
				if (total == board.getRow() - 1){
					for(int k = 0; i < board.getCol(); k++)
						if (board.getSlots()[k].charAt(i) == '_')
							return new int[] {k,i};
				}
			}
			
		//Check the diagonals. If one can win, find the empty location and return it
		int total2 = 0;
		total = 0;
		for(int i = 0; i < board.getRow(); i++){
			
			if(board.getSlots()[i].charAt(i) == x)
				total++;
			else if(board.getSlots()[i].charAt(i) == '_')
				total += 0;
			else
				total--;
			if(board.getSlots()[i].charAt(board.getCol() - i - 1) == x)
				total2++;
			else if(board.getSlots()[i].charAt(board.getCol() - i - 1) == '_')
				total2 += 0;
			else
				total2--;
			
		}
		//Find the empty first diagonal
		if (total == board.getRow() - 1)
			for(int i = 0; i < board.getRow(); i++)
					if(board.getSlots()[i].charAt(i) == '_')
						return new int[] {i,i};
		//Find the empty second diagonal
		if (total2 == board.getRow() - 1)
			for(int i = 0; i < board.getRow(); i++)
					if(board.getSlots()[i].charAt(board.getRow() - i - 1) == '_')
						return new int[] {i, board.getRow() - i - 1};
		//There is no winning row, column, or diagonal
		return null;
	}
    
}
