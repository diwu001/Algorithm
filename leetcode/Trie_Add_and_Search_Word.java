
public class Trie_Add_and_Search_Word {
	class TrieNode {
        // Initialize your data structure here.
        private  int len;
        private  char val;
    
        private TrieNode[] child;
        public TrieNode() {
            len=0;
            child=new TrieNode[26];
        }
    }
	
    private TrieNode root;
	
	public Trie_Add_and_Search_Word_Leetcode() {
	    root = new TrieNode();
	}
	
    // Adds a word into the data structure.
    public void addWord(String word) {
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

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
		if(word==null||word.length()==0) return false;
		return dfs(word,root);
	}
	
	public boolean dfs(String s, TrieNode cur){
		if(cur==null) return false;
		if(s.length()==0) {
			if(cur.len>0) return true;
			return false;
		}
		boolean flag=false;
		if(s.charAt(0)=='.') {
			for(char c='a';c<='z';c++) {
				flag|=dfs(s.substring(1),cur.child[c-'a']) ;
			}
		} else {
			int pos=s.charAt(0)-'a';
			if(cur.child[pos]==null) return false;	
			flag = dfs(s.substring(1),cur.child[pos]);
		}
		return flag;
    }
}
