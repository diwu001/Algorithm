import java.util.*;
public class Lintcode_Find_Connected_Component_in_Undirected_Graph {
	 public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        if(nodes==null||nodes.size()==0) return result;
	        Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
	        for(UndirectedGraphNode node:nodes) {
	            ArrayList<Integer> path = new ArrayList<Integer>();
	            if(dfs(node,nodes,path,visited)) {
	                Collections.sort(path); 
	                result.add(path);
	            }
	        }
	        return result;
	    }
	    
	    public boolean dfs(UndirectedGraphNode node,ArrayList<UndirectedGraphNode> nodes, ArrayList<Integer> path, Set<UndirectedGraphNode> visited) {
	        if(visited.contains(node)) return false;
	        path.add(node.label);
	        visited.add(node);
	        for(UndirectedGraphNode neighbor:node.neighbors) {
	            dfs(neighbor,nodes,path,visited);
	        }
	        return true;
	    }
}
