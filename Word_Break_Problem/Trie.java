import java.util.ArrayList;
public class Trie {
	private TrieNode root;
	
	public Trie() {
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
	
    // Returns if the word is in the trie.
    public boolean search(String word) {
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
    
	//Generate all prefixes for word
    public ArrayList<Integer> getAllPrefixes(String word) {
    	String prefix="";
    	ArrayList<Integer> prefixes = new ArrayList<Integer>();
    	TrieNode cur = root;
    	char[] temp=word.toCharArray();
	    for(int i=0;i<temp.length;i++) {
	    	int pos=temp[i]-'a';
	        if(cur.child[pos]==null) return prefixes;
	        cur=cur.child[pos];
	        prefix+=temp[i];
	        if(cur.len>0) prefixes.add(prefix.length());
	    }
	    return prefixes;
    }
}
