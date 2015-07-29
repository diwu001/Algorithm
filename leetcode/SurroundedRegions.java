import java.util.LinkedList;
public class SurroundedRegions {
	public void solve(char[][] board) {
        if(board==null||board.length<=2) return;
        int m=board.length,n=board[0].length;
        LinkedList<Integer> q=new LinkedList<Integer>();
        
        for(int i=0;i<m;i++) {
            if(board[i][0]=='O') {board[i][0]='#'; q.offer(i*n);}
            if(board[i][n-1]=='O') {board[i][n-1]='#';q.offer(i*n+n-1); }
        }
        for(int i=0;i<n;i++) {
            if(board[0][i]=='O') {board[0][i]='#'; q.offer(i);  }
            if(board[m-1][i]=='O') {board[m-1][i]='#'; q.offer((m-1)*n+i); }
        }
        
        while(!q.isEmpty()) {
            int val=q.poll();
            int row=val/n;
            int col=val%n;
            if(row>0&&board[row-1][col]=='O') {
                q.offer((row-1)*n+col);
                board[row-1][col]='#';
            } 
            if(row<m-1&&board[row+1][col]=='O') {
                q.offer((row+1)*n+col);
                board[row+1][col]='#';
            }
            if(col>0&&board[row][col-1]=='O') {
                q.offer(row*n+col-1);
                board[row][col-1]='#';
            }
            if(col<n-1&&board[row][col+1]=='O') {
                q.offer(row*n+col+1);
                board[row][col+1]='#';
            }
        }
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j]=='O') board[i][j]='X';
                if(board[i][j]=='#') board[i][j]='O';
            }
        }
    }
}
