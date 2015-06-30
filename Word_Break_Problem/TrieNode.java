public class TrieNode {
	 int len;
     char val;
     TrieNode[] child;
	 
     public TrieNode() {
        len=0;
        child=new TrieNode[26];
    }
}
