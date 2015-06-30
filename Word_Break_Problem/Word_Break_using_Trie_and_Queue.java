import java.util.*;
import java.io.*;

public class Word_Break_using_Trie_and_Queue {
	public static void main(String[] args) throws Exception{
		List<String> ss = new ArrayList<String>();				
		FileInputStream file = new FileInputStream("/wordsforproblem.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(file));                              
        String line = reader.readLine();
        while(line != null){                
                if(line!=null&&line.length()>1) 
                	ss.add(line);
                line = reader.readLine();
        }
        file.close();		
        long startTime = System.nanoTime();
        
	    Trie trie = new Trie();
	    Queue<Pair> queue = new LinkedList<Pair>();
		for(int i=0;i<ss.size();i++) {
			String word=ss.get(i);
			ArrayList<Integer> prefixes = trie.getAllPrefixes(word);
			for(Integer prefix:prefixes) {
				queue.offer(new Pair(word,word.substring(prefix)));
			}
			trie.addWord(word);		
		}
		
		HashSet<String> visited = new HashSet<String>();
		String longestWord = "";
		int maxLen = 0;
		String secondLongestWord = "";
		int secondMaxLen = 0;
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			String word = p.word;
			String suffix = p.suffix;
			if(trie.search(suffix)) {
				if(word.length()>maxLen) {
					maxLen=word.length();
					longestWord=word;
				} else if(word.length()>secondMaxLen) {
					secondMaxLen=word.length();
					secondLongestWord=word;
				}
				visited.add(word);
			} else {
				ArrayList<Integer> prefixes = trie.getAllPrefixes(suffix);
				for(Integer prefix:prefixes) {
					queue.offer(new Pair(word,suffix.substring(prefix)));
				}
			}
		}

		System.out.println(longestWord);	
		System.out.println(secondLongestWord);	
		System.out.println(visited.size());
		
		long endTime = System.nanoTime();		
		System.out.println("Took "+(endTime - startTime)/1000000 + "ms");
	}
}
