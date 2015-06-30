/*	Write a program to solve a Sudoku puzzle by filling the empty cells.
	Empty cells are indicated by the character '.'.
	You may assume that there will be only one unique solution.*/

package sudoku_solver;

public class Sudoku_Solver {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0) return;     
        dfs(board, 0, 0);
    }
    
    public boolean dfs(char[][] board, int x, int y) {
        int n = board.length;
        if(x == n || y == n) return true;
        if(board[x][y] == '.') {
            for(int k=1; k<=9; k++) {
                if(isValid(board, x, y, (char)(k+'0'))) {
                    board[x][y] = (char)(k + '0');
                    int nextX = x, nextY = y;
                    if(y == 8) {
                        nextX++; 
                        nextY = 0;
                    }
                    else nextY = y+1;
                    if(dfs(board, nextX, nextY)) return true;
                    board[x][y] = '.';
                } 
            }
            return false;
        } else {
            if(y == 8) {
                x = x+1; 
                y = 0;
            }
            else y = y+1;
            return dfs(board, x, y);
        }
    }
    
    public boolean isValid(char[][] board, int x, int y, char c) {
        int n = board.length;
        for(int i=0; i<n; i++) {
            if(board[i][y] == c) return false;
            if(board[x][i] == c) return false;
        }
        for(int i=0; i<n/3; i++){
            for(int j=0; j<n/3; j++){
                if(board[(x/3)*3 + i][(y/3)*3 + j] == c) return false;
            }
        }
        return true;
    }
}
