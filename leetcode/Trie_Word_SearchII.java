import java.util.*;
public class Trie_Word_SearchII {
    public static  ArrayList<String> findWords(char[][] board, String[] words) {
        int m=board.length,n=board[0].length;
        boolean[][] visited = new boolean[m][n];
        Trie trie = new Trie();
        for(int i=0;i<words.length;i++) trie.insert(words[i]);     
        HashSet<String> res = new HashSet<String>();
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                TrieNode cur=trie.root;               
                dfs(board,visited,"",i,j,trie,res);
            }
        }
        
        return new ArrayList<String>(res);  
    }
    
    public static void dfs(char[][] board,boolean[][] visited,String str,int x,int y,Trie trie,HashSet<String> res) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;  
        if (visited[x][y]) return;  
          
        str += board[x][y];  
        if (!trie.startsWith(str)) return;  
          
        if (trie.search(str)) {  
            res.add(str);  
        }  
          
        visited[x][y] = true;  
        dfs(board, visited, str, x - 1, y, trie,res);  
        dfs(board, visited, str, x + 1, y, trie,res);  
        dfs(board, visited, str, x, y - 1, trie,res);  
        dfs(board, visited, str, x, y + 1, trie,res);  
        visited[x][y] = false;  
    }
    
    static class TrieNode {
        private  int len;
        private  char val;
    
        private TrieNode[] child;
        public TrieNode() {
            len=0;
            child=new TrieNode[26];
        }
    }

    static class Trie {
	    private  TrieNode root;
	
	    public Trie() {
	        root = new TrieNode();
	    }
	
	    // Inserts a word into the trie.
	    public void insert(String word) {
	        if(word==null||word.length()==0) return;
	        TrieNode cur = root;
	        char[] temp=word.toCharArray();
	        for(int i=0;i<temp.length;i++) {
	            int pos=temp[i]-'a';
	            if(cur.child[pos]==null) {
	                cur.child[pos]=new TrieNode(); 
	                cur.child[pos].val=temp[i];
	            }
	            cur=cur.child[pos];
	        }
	        cur.len=temp.length;
	    }
	
	    // Returns if there is any word in the trie
	    // that starts with the given prefix.
	    public  boolean startsWith(String prefix) {
	        if(prefix==null||prefix.length()==0) return false;
	        TrieNode cur = root;
	        char[] temp=prefix.toCharArray();
	        for(int i=0;i<temp.length;i++) {
	            int pos=temp[i]-'a';	          
	            if(cur.child[pos]==null) {	            	
	            	return false;
	            }
	            cur=cur.child[pos];
	        }
	        return true;
	    }
	    public  boolean search(String word) {
	        if(word==null||word.length()==0) return false;
	        TrieNode cur = root;
	        char[] temp=word.toCharArray();
	        for(int i=0;i<temp.length;i++) {
	            int pos=temp[i]-'a';	          
	            if(cur.child[pos]==null) {	            	
	            	return false;
	            }
	            cur=cur.child[pos];
	        }
	        return cur.len>0;
	    }
    }
}
