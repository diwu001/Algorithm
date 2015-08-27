//http://www.lintcode.com/en/problem/longest-words/
//Solved in One pass
import java.util.ArrayList;
public class Lintcode_Longest_Words {
	ArrayList<String> longestWords(String[] dictionary) {
        ArrayList<String> result = new ArrayList<String>();
        for(String s:dictionary) {
            if(result.size()==0||s.length()>result.get(0).length()) {
                result.clear();
                result.add(s);
            } else if(s.length()==result.get(0).length()) {
                result.add(s);
            }
        }
        return result;
    }
}
