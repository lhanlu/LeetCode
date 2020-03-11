/**
 * According to the Wikipedia's article: "The Game of Life, 
 * also known simply as Life, is a cellular automaton devised by 
 * the British mathematician John Horton Conway in 1970."
 * Given a board with m by n cells, each cell has an initial state 
 * live (1) or dead (0). Each cell interacts with its eight neighbors 
 * (horizontal, vertical, diagonal) using the following four rules 
 * (taken from the above Wikipedia article):
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of 
 * the board given its current state. The next state is created by 
 * applying the above rules simultaneously to every cell in the current state, 
 * where births and deaths occur simultaneously.
 * Example:
 * Input: [  [0,1,0],  [0,0,1],  [1,1,1],  [0,0,0]]
 * Output: [  [0,0,0],  [1,0,1],  [0,1,1],  [0,1,0]]
 */
class Solution {
    public void gameOfLife(int[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                int lives = count(board, i, j);
                if(board[i][j] == 1){
                    if(lives < 2 || lives > 3) board[i][j] = -1;
                }else{
                    if(lives == 3) board[i][j] = 2;
                }
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] > 0) board[i][j] = 1;
                if(board[i][j] < 0) board[i][j] = 0;
            }
        }
    }

    public int count(int[][] board, int i, int j){
        int lives = 0;
        int[] add = new int[]{0,1,-1};
        for(int m = 0; m < add.length; m++){
            int ma = add[m];
            for(int n = 0; n < add.length; n++){
                int na = add[n];
                if(ma == 0 && na == 0) continue;
                if(ma+i >= 0 && ma+i < board.length && na+j >= 0 && na+j < board[0].length){
                    if(Math.abs(board[ma+i][na=j]) == 1) lives++;
                }
            }
        }
        return lives;
    }
}