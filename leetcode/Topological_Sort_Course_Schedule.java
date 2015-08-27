import java.util.*;
public class Topological_Sort_Course_Schedule {
	//BFS
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses==0||prerequisites==null||prerequisites.length==0) return true;
        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<Integer,ArrayList<Integer>>();
        HashMap<Integer,Integer> in = new HashMap<Integer,Integer>();
        for(int i=0;i<numCourses;i++) {           
            graph.put(i,new ArrayList<Integer>());
            in.put(i,0);
        }
        
        for(int i=0;i<prerequisites.length;i++) {
            int from=prerequisites[i][1];
            int to=prerequisites[i][0];
            graph.get(from).add(to);
            in.put(to,in.get(to)+1);
        }
    
        int count=0;
        LinkedList<Integer> q=new LinkedList<Integer>();
        for(Integer i:in.keySet()) {
            if(in.get(i)==0) {
                q.offer(i);
                count++;
            }
        }
    
        while(!q.isEmpty()) {
            int cur=q.poll();
            for(Integer i:graph.get(cur)) {
                in.put(i,in.get(i)-1);
                if(in.get(i)==0) {
                    q.offer(i);
                    count++;
                }
            }
        }
        return count== numCourses;
    }
	
	//DFS
	public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        if(numCourses==0||prerequisites==null||prerequisites.length==0) return true;
        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<numCourses;i++) {           
            graph.put(i,new ArrayList<Integer>());
        }
        
        for(int i=0;i<prerequisites.length;i++) {
            int from=prerequisites[i][1];
            int to=prerequisites[i][0];
            graph.get(from).add(to);
        }
        
        HashSet<Integer> path = new HashSet<Integer>();
        HashSet<Integer> visited = new HashSet<Integer>();
        for(int i=0;i<numCourses;i++) {   
            if(!dfs(numCourses,graph,path,visited,i)) return false;
        }
        return true;
    }
    
    public boolean dfs(int numCourses,HashMap<Integer,ArrayList<Integer>> graph,HashSet<Integer> path,HashSet<Integer> visited,int i) {
        if(path.contains(i)) return false;
        if(visited.size()==numCourses) return true;
        if(!visited.contains(i)) {
            visited.add(i);
            path.add(i);
            for(Integer j:graph.get(i)) {
                if(!dfs(numCourses,graph,path,visited,j)) return false;
            }
            path.remove(i);
        }
        return true;
    }
}