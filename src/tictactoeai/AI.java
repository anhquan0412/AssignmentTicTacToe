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
public abstract class AI {
    protected Board board;
    protected char computerO;
    protected char playerX;
    public AI(Board b)
    {
        board = b;
    }
    public void setSymbol(char x) //not used yet
    {
        playerX = x;
        computerO = (x == 'O')? 'X':'O';
    }
    
    public abstract int[] move();
            
    
}
