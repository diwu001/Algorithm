//http://www.lintcode.com/en/problem/two-strings-are-anagrams/
import java.util.HashMap;
public class Lintcode_Two_Strings_are_Anagrams {
	/**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
	public boolean anagram(String s, String t) {
        if(s==null||t==null) return false;
        if(s.length()==0||t.length()==0) return false;
        HashMap<Character,Integer> map =new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) map.put(c,1);
            else map.put(c,map.get(c)+1);
        }
        for(int i=0;i<t.length();i++) {
            char c = t.charAt(i);
            if(!map.containsKey(c)) return false;
            else map.put(c,map.get(c)-1);
            if(map.get(c)==0) map.remove(c);
        }
        return map.size()==0;
    }
	
//------------------------------------------------------------------
	
	public boolean anagram2(String s, String t) {
        if (s.length() != t.length()) {
           return false;
        }
        
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[(int) s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            count[(int) t.charAt(i)]--;
            if (count[(int) t.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }
}
