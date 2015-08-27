import java.util.*;
public class Word_LadderII {	
    Map<String,Integer> distance = new HashMap<String,Integer>();
    Map<String,List<String>> graph = new HashMap<String,List<String>>();
    List<List<String>> result = new ArrayList<List<String>>();
	List<String> path = new ArrayList<String>();
	
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        if(dict==null||start==null||end==null||start.length()!=end.length()) return result;
        bfs(end,start,dict);
        path.add(start);
        dfs(start,end,dict);
        return result;
    }
    
    public void dfs(String cur, String end, Set<String> dict) {
        if(cur.equals(end)) {
            result.add(new ArrayList<String>(path));
            return;
        }
        for(String n:graph.get(cur)) {
            if(distance.get(n)+1==distance.get(cur)) {
                path.add(n);
                dfs(n,end,dict);
                path.remove(path.size()-1);
            }
        }
    }
    
    public void bfs(String start, String end, Set<String> dict) {
        Queue<String> q = new LinkedList<String>();
        q.offer(start);
        distance.put(start,0);
        for(String s:dict) graph.put(s,new ArrayList<String>());
        while(!q.isEmpty()) {
            String cur = q.poll();
            List<String> neighbors = helper(cur,dict);
        
            for(String n:neighbors) {
                graph.get(n).add(cur);
                if(!distance.containsKey(n)) {
                	distance.put(n,distance.get(cur)+1);
                    q.offer(n);
                }
            }
        }
    }
    
    public List<String> helper(String cur, Set<String> dict) {
        List<String> neighbors = new ArrayList<String>();
        for(int i=0;i<cur.length();i++) {
            char[] temp=cur.toCharArray();
            for(char c='a';c<='z';c++) {
                temp[i]=c;
                String s = new String(temp);
                if(!s.equals(cur) && dict.contains(s)) {
                    neighbors.add(s);
                }
            }
        }
        return neighbors;
    }
}
