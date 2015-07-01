import java.util.HashMap;
public class Lintcode_Longest_Substring_with_at_Most_K_Distinct_Chars {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s==null||k==0) return 0;
        int n=s.length();
        if(n<=k) return n;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		
        int i=0,j=0,maxLen=1;
        while(j<n) {
            char c = s.charAt(j);
            if(!map.containsKey(c)) map.put(c,1);
            else map.put(c,map.get(c)+1);
            
            if(map.size()<=k) {
                maxLen = Math.max(maxLen,j-i+1);
            } else {
                while(map.size()>k) {
                    map.put(s.charAt(i),map.get(s.charAt(i))-1);
                    if(map.get(s.charAt(i))==0) map.remove(s.charAt(i));
                    i++;
                }
            }
			
            j++;
        }
        return maxLen;
    }
}
