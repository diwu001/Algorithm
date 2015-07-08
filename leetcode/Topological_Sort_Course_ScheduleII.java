import java.util.*;
public class Topological_Sort_Course_ScheduleII {
	//BFS
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] empty = {};
       if(numCourses==0) return empty;
       
       int[] result = new int[numCourses];
       if(numCourses==1) {
           result[0]=0;
           return result;
       }
       HashMap<Integer,Integer> in = new HashMap<Integer,Integer>();
       HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
       for(int i=0;i<numCourses;i++) {
           in.put(i,0);
           map.put(i,new ArrayList<Integer>());
       }
       
       for(int i=0;i<prerequisites.length;i++) {
           int from=prerequisites[i][1];
           int to=prerequisites[i][0];
           map.get(from).add(to);
           in.put(to,in.get(to)+1);
       }
       
       int index=0;
       LinkedList<Integer> q = new LinkedList<Integer>();
       for(int key:in.keySet()) {
           if(in.get(key)==0) {
               q.offer(key);
               result[index++]=key;
           }
       }
       
       while(!q.isEmpty()) {
           int cur=q.poll();
           for(int neighbor:map.get(cur)) {
               in.put(neighbor,in.get(neighbor)-1);
               if(in.get(neighbor)==0) {
                   q.offer(neighbor);
                   result[index++]=neighbor;
               }
           }
       }
       if(index<numCourses)  return empty;
       return result;
   }
   
	//DFS	
	public static int[] findOrder2(int numCourses, int[][] prerequisites) {
		int[] empty = {};
        if(numCourses==0) return empty;
        int[] result = new int[numCourses];
        if(prerequisites==null||prerequisites.length==0) {
            for(int i=0;i<numCourses;i++) result[i]=i;
            return result;
        }
        
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<numCourses;i++) {
            map.put(i,new ArrayList<Integer>());
        }
        
        for(int i=0;i<prerequisites.length;i++) {
            int from=prerequisites[i][1];
            int to=prerequisites[i][0];
            map.get(from).add(to);
        }
        
        HashSet<Integer> visited=new HashSet<Integer>();
        ArrayList<Integer> path = new ArrayList<Integer>();       
        ArrayList<Integer> temp = new ArrayList<Integer>();
       
        for(int i=0;i<numCourses;i++) {
            if(!dfs(map,visited,i,path,temp)) return empty;
        }
              
        int index=0;
        
        for(int i=temp.size()-1;i>=0;i--) result[index++]=temp.get(i);
        return result;
    }
    
    public static boolean dfs(HashMap<Integer,ArrayList<Integer>> map, HashSet<Integer> visited, int i,ArrayList<Integer> path,ArrayList<Integer> temp) {
        if(path.contains(i)) return false;
        if(visited.size()==map.size()) return true;
        if(!visited.contains(i)) {
            visited.add(i);
            path.add(i);
            for(int neighbor:map.get(i)) {
                if(!dfs(map,visited,neighbor,path,temp)) return false;
            }
            path.remove(path.size()-1);
            temp.add(i);
        }
        return true;
    }
}
