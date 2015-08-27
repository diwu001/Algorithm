import java.util.HashMap;
public class Isisomorphism_String {
    // Time O(n), Space O(n)
    public boolean isIsomorphic(String s, String t) {
        if(s==null||t==null||s.length()<=1||t.length()<=1) return true;
        HashMap<Character,Character> m1=new HashMap<Character,Character>();
        HashMap<Character,Character> m2=new HashMap<Character,Character>();
        for(int i=0;i<s.length();i++) {
            char c1=s.charAt(i);
            char c2=t.charAt(i);
            if(m1.containsKey(c1)&&m1.get(c1)!=c2) return false;
            if(m2.containsKey(c2)&&m2.get(c2)!=c1) return false;
            m1.put(c1,c2);
            m2.put(c2,c1);
        }
        return true;
    }
}
