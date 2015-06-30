//http://www.lintcode.com/en/problem/route-between-two-nodes-in-graph/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;
public class Lintcode_Route_Between_Two_Nodes_in_Graph {
	//DFS
	public boolean hasRoute(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t) {
		if(s==t) return true;
		for(DirectedGraphNode n:s.neighbors) {
			if(hasRoute(graph,n,t)) return true;
		}
		return false;
	}
	
	//--------------------------------------------
	
	//BFS
	public boolean hasRoute2(ArrayList<DirectedGraphNode> graph, 
        DirectedGraphNode s, DirectedGraphNode t) {
		if(s==t) return true;
		Set<DirectedGraphNode> set = new HashSet<DirectedGraphNode>();
		Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
		q.offer(s);
		while(!q.isEmpty()) {
			int size=q.size();
			for(int i=0;i<size;i++) {
				DirectedGraphNode cur = q.poll();
				for(DirectedGraphNode n:cur.neighbors) {
				    if(n==t) return true;
				    if(!set.contains(n)) {
				        q.offer(n);
				        set.add(n);
				    }
				}
			}
		}
		
		return false;
		}
}
