package tictactoeai;

import static org.junit.Assert.*;

import org.junit.Test;

public class tictactest {

	@Test
	public void testAIBoard() {
		AI easy, medium;
		Board b;
		for(int i = 1; i < 50; i++){
			b = new Board(i);
			easy = new Level1AI(b);
			medium = new Level2AI(b);
			assert (easy.board.getRow() == i);
			assert (medium.board.getRow() == i);
			assert(easy.board.setMove(i/2, i, 'X') == true);
			assert(medium.board.setMove(i/2, i, 'X') == true);
			assert(easy.board.setMove(i/2, i, 'X') == false);
			assert(medium.board.setMove(i/2, i, 'X') == false);
		}
	}
	@Test
	public void testLevel2Win(){
		AI row, col, diag1, diag2;
		int  move[] = {0,0};
		Board a,b,c,d;
		for (int i = 1; i < 50; i++){
			a = new Board(i);
			b = new Board(i);
			c = new Board(i);
			d = new Board(i);
			row = new Level2AI(a);
			col = new Level2AI(b);
			diag1 = new Level2AI(c);
			diag2 = new Level2AI(d);
			for(int j = 0; j < i - 1; j++){
				row.board.setMove(j, 0, 'O');
				col.board.setMove(0, j, 'O');
				diag1.board.setMove(j, j, 'O');
				diag2.board.setMove(j, i - j - 1, 'O');
			}
			move = row.move();
			row.board.setMove(move[0], move[1], 'O');
			assertTrue(row.board.hasWon('O'));
			
			move = col.move();
			col.board.setMove(move[0], move[1], 'O');
			assertTrue(col.board.hasWon('O'));
			
			move = diag1.move();
			diag1.board.setMove(move[0], move[1], 'O');
			assertTrue(diag1.board.hasWon('O'));
			
			move = diag2.move();
			diag2.board.setMove(move[0], move[1], 'O');
			assertTrue(diag2.board.hasWon('O'));
			
		}
	}

}
