/*Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.
Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.*/

public class ShortestWordDistance {
	int shortestDistance(String[] words, String word1, String word2) {
        if(words.length <= 1) return 0;
        int p1 = -1, p2 = -1, n = words.length, minLen = n;
        for(int i = 0; i < n; i++) {
            if(words[i].equals(word1)) {
                p1 = i;
                if(p2 != -1) minLen = Math.min(minLen, i - p2);
            } else if(words[i].equals(word2)) {
                p2 = i;
                if(p1 != -1) minLen = Math.min(minLen, i - p1);
            }
        }
        return minLen;
    }
}
