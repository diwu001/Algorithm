/*Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
"abc" -> "bcd" -> ... -> "xyz". Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], Return:
[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
Note: For the return value, each inner list's elements must follow the lexicographic order.*/

import java.util.*;

public class GroupShiftedString {
	List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(int i = 0; i < strings.length; i++) {
            String key = getCode(strings[i]);
            if(!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(strings[i]);
        }
        for(ArrayList<String> list: map.values()) {
            Collections.sort(list);
            result.add(list);
        }
        return result;
    }
    
	// abc xyz both get "1#1#", so they're in same group. But ab get "1#", ba get "25#", they're in different groups
    String getCode(String s) {
        if(s.length()==0) return "";
        StringBuilder sb = new StringBuilder();
        for(int  i = 1; i < s.length(); i++) {
            int dif = (s.charAt(i) - s.charAt(i - 1) + 26) % 26;
            sb.append(dif).append("#");
        }
        return sb.toString();
    }
}
