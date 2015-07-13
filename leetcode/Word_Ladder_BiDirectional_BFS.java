import java.util.*;
public class Word_Ladder_BiDirectional_BFS {
	public int ladderLength(String start, String end, Set<String> dict) {
        if(start==null||end==null||dict==null) return -1;
        if(start.length()==0||end.length()==0||dict.size()==0) return 0;

        LinkedList<String> q1 = new LinkedList<String>();
        LinkedList<String> q2 = new LinkedList<String>();
        q1.offer(start);
        q2.offer(end);
        
        HashMap<String,Integer> dis1=new HashMap<String,Integer>();
        HashMap<String,Integer> dis2=new HashMap<String,Integer>();
        dis1.put(start,1);
        dis2.put(end,1);

        while(!q1.isEmpty()||!q2.isEmpty()) {
            if(!q2.isEmpty() && (q1.isEmpty() || q1.size() >= q2.size())){
                LinkedList<String> temp=q1;
                q1=q2;
                q2=temp;
                HashMap<String,Integer> tempMap=dis1;
                dis1=dis2;
                dis2=tempMap;
            }     
            String curStr=q1.poll();
            int curDis=dis1.get(curStr);
            for(int j=0;j<curStr.length();j++) {
                char[] temp = curStr.toCharArray();
                for(char k='a';k<='z';k++) {
                    temp[j]=k;
                    String tempStr = new String(temp);
                    if(tempStr.equals(curStr)) continue; 
                    if(dis2.containsKey(tempStr)) return curDis+dis2.get(tempStr);   
                    if(dict.contains(tempStr)&&!dis1.containsKey(tempStr)) {
                        q1.offer(tempStr);
                        dis1.put(tempStr,curDis+1);
                    }
                }
            }
        }
        return 0;
    }
}
