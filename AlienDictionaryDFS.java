import java.util.*;
public class AlienDictionaryDFS {
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0) return "";
        int n = words.length;
        Map<Character, HashSet<Character>> map = new HashMap<Character, HashSet<Character>>();
        Set<Character> dict = new HashSet<Character>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < words[i].length(); j++) {
                dict.add(words[i].charAt(j));
            }
        }
        for(Character c : dict) map.put(c, new HashSet<Character>());

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < words[i].length(); j++) {
                if(j >= words[i - 1].length()) break;
                if(words[i - 1].charAt(j) != words[i].charAt(j)) {
                    char from = words[i - 1].charAt(j);
                    char to = words[i].charAt(j);
                    map.get(from).add(to);
                    break;
                } else continue;
            }
        }
        
        StringBuilder result = new StringBuilder();
        Set<Character> visited=new HashSet<Character>();
        List<Character> path = new ArrayList<Character>();       
        List<Character> temp = new ArrayList<Character>();
       
        for(Character c : dict) {
            if(!dfs(map, visited, c, path, temp)) return "";
        }
        
        for(int i=temp.size()-1;i>=0;i--) result.append(temp.get(i));
        
        if(result.length() != map.size()) return "";
        return result.toString();
    }
    
    boolean dfs(Map<Character, HashSet<Character>> map, Set<Character> visited, char c, List<Character> path, List<Character> temp) {
        if(path.contains(c)) return false;
        if(visited.size()==map.size()) return true;
        if(!visited.contains(c)) {
            visited.add(c);
            path.add(c);
            for(Character ne: map.get(c)) {
                if(!dfs(map, visited, ne, path, temp)) return false;
            }
            path.remove(path.size() - 1);
            /*Out degree is 0 for c*/
            temp.add(c);
        }
        return true;
    }
}
