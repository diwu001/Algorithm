/*There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. 
You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.
For example, given the following words in dictionary,
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
The correct order is: "wertf".

Note:
You may assume all letters are in lowercase.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.*/

import java.util.*;
public class AlienDictionaryBFS {
	static String alienOrder(String[] words) {
        if(words == null || words.length == 0) return "";
        int n = words.length;
        Map<Character, HashSet<Character>> map = new HashMap<Character, HashSet<Character>>();
        Map<Character, Integer> in = new HashMap<Character, Integer>();
        Set<Character> dict = new HashSet<Character>();
        /*Get all the letters needs to sort*/
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < words[i].length(); j++) {
                dict.add(words[i].charAt(j));
            }
        }
        for(Character c : dict) {
            map.put(c, new HashSet<Character>());
            in.put(c, 0);
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < words[i].length(); j++) {
                if(j >= words[i - 1].length()) break;
                if(words[i - 1].charAt(j) != words[i].charAt(j)) {
                    char from = words[i - 1].charAt(j);
                    char to = words[i].charAt(j);
                    map.get(from).add(to);
                    in.put(to, in.get(to) + 1);
                    break;
                } else continue;
            }         
        }
        
        StringBuilder result = new StringBuilder();
        LinkedList<Character> q = new LinkedList<Character>();
        for(Character c : in.keySet()) {
            if(in.get(c) == 0) {
                q.offer(c);
                result.append(c);
            }
        }
        
        while(!q.isEmpty()) {
            char cur = q.poll();
            for(Character c : map.get(cur)) {
                in.put(c, in.get(c) - 1);
                if(in.get(c) == 0) {
                    q.offer(c);
                    result.append(c);
                }
            }
        }

        if(result.length() != map.size()) return "";
        return result.toString();
    }
	
	public static void main(String[] args) {
		String[] ss = {"wrt","wrf","er","ett","rftt"};
		alienOrder(ss);
	}
}
