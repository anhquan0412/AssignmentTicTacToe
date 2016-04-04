/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeai;
import java.util.Scanner;
/**
 *
 * @author anhqu
 */
public class TicTacToeAI {

    /**
     * @param args the command line arguments
     */
    // ONLY WORK WITH 3X3 FOR NOW!!!
    
    private Board gameBoard;
    private int turn = -1; //0 is player, 1 is AI
    private Scanner in = new Scanner(System.in);
    private char playerX;
    private char computerO;
    
    private boolean isOver;
    private int whoWin;//0: player win, 1: AI win
    
    private AI AIcontroller;
    
    public TicTacToeAI() throws Exception
    {       
        welcome();
        init();
        do
        {
            
            if(turn==0)
                playerTurn();
            else
                AITurn();
            
            gameBoard.paint();
            
            //update turn
            turn= ((turn==1)?0:1);
            
            //update the game
            if(gameBoard.isDraw() || whoWin >=0)
                isOver = true;
        }
        while(!isOver);
        
        if(whoWin==1)
            System.out.println("AI wins");
        else if (whoWin==0)
            System.out.println("You win!");
        else
            System.out.println("Draw");
        
        System.out.println("Thank you for playing");
        

    }
    
    public void playerTurn()
    {
        boolean valid = false;
        do
        {
            System.out.print("What is your move? Please type a row number\n" + 
                    "from 1 to 3 and a column number from 1 to 3 (separated by space): ");
            int row = in.nextInt() - 1;
            int col = in.nextInt() - 1;
            valid = gameBoard.setMove(row, col, playerX);
            gameBoard.currentRow = row;
            gameBoard.currentCol = col;
            
            if (gameBoard.hasWon(playerX))
                whoWin = 0;
        }
        while(!valid);
        
    }
    public void AITurn()
    {
        System.out.println("AI turn:");
        int[] nextMove = AIcontroller.move();
        gameBoard.setMove(nextMove[0], nextMove[1], computerO);
        if(gameBoard.hasWon(computerO))
            whoWin = 1;
    }
    
    
    public void init() throws Exception
    {
        playerX='X';
        computerO = 'O';
        gameBoard  = new Board(3,3);
        isOver = false;
        whoWin = -1; //0: player win, 1: AI win
        
        AIcontroller = new Level1AI(gameBoard);
        
        
        gameBoard.paint();
    }
    public void welcome()
    {
        String input;
        do
        {
            System.out.println("Welcome to Tic Tac Toe");
            System.out.print("You want to go first? (y/n) ");
            input = in.next();
            if(input.equals("y"))
                turn = 0;
            else if(input.equals("n"))
                turn = 1;
            else
                System.out.println("Invalid input");
        }
        while(turn== -1);
    }
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        new TicTacToeAI();
    }
    
}
