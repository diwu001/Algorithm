package wordladder;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
public class Word_Ladder_BFS {
	public static int ladderLength(String start, String end, Set<String> dict) {
        if(start==null||end==null||dict==null) return -1;
        if(start.length()==0||end.length()==0||dict.size()==0) return 0;
        HashSet<String> visited = new HashSet<String>();
        visited.add(start);
        LinkedList<String> q = new LinkedList<String>();
        q.offer(start);
        int len=1;
        while(!q.isEmpty()) {
            int size=q.size();
            for(int i=0;i<size;i++) {
                String cur = q.poll();
                for(int j=0;j<cur.length();j++) {
                    char[] temp = cur.toCharArray();
                    for(char k='a';k<='z';k++) {
                        temp[j]=k;
                        String tempStr = new String(temp);
                        System.out.println(tempStr);
                        if(tempStr.equals(start)) continue;
                        if(tempStr.equals(end)) return len+1;
                        if(dict.contains(tempStr)&&!visited.contains(tempStr)) {
                            q.offer(tempStr);
                            visited.add(tempStr);
                        }
                    }
                }
            }
            len++;
        }
        return 0;
    }
}
