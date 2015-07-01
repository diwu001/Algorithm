// http://www.lintcode.com/en/problem/find-the-weak-connected-component-in-the-directed-graph/
/* Find the number Weak Connected Component in the directed graph. 
 * Each node in the graph contains a label and a list of its neighbors. 
 * (a connected set of a directed graph is a subgraph in which any two vertices are connected by direct edge path.)*/

import java.util.*;
public class Lintcode_Find_Weak_Connected_Component_in_Directed_Graph {
    class DJSetNode {
        int rank;
        DJSetNode parent;
        public DJSetNode(int r) {
            rank=r;
        }
    }
    
    // key is the root of each tree
    // value is the list of a weak connected component in the same tree
    Map<DJSetNode,ArrayList<Integer>> forest = new HashMap<DJSetNode,ArrayList<Integer>>();
    
     DJSetNode makeSet() {
        DJSetNode cur = new DJSetNode(0);    
        forest.put(cur,new ArrayList<Integer>());
        return cur;
    }
    
    DJSetNode find(DJSetNode n) {
        if (n == null) return n;
        while (n.parent!=null) {
            n = n.parent;
        }
        return n;
    }
    
    DJSetNode merge(DJSetNode n1, DJSetNode n2) {
        DJSetNode r1 = find(n1);   
        DJSetNode r2 = find(n2);
        if (r1 == r2) return r1;

        if (r1.rank > r2.rank) {  
            r2.parent = r1;    
            forest.get(r1).addAll(forest.get(r2));
            forest.remove(r2);       
            return r1;              
        }
        else if (r1.rank < r2.rank) { 
            r1.parent = r2;
            forest.get(r2).addAll(forest.get(r1));
            forest.remove(r1);
            return r2;
        }
        else {                      
            r2.parent = r1;    
            forest.get(r1).addAll(forest.get(r2));
            forest.remove(r2);
            r1.rank=r1.rank+1;             
            return r1;
        }
    }
    
    Map<DirectedGraphNode,DJSetNode> map = new HashMap<DirectedGraphNode,DJSetNode>();
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
		//visited can make sure each node in graph only be visited once
        Set<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();
        
        for(DirectedGraphNode node:nodes) {
            if(!visited.contains(node)) {
                dfs(visited,node,nodes);
            }
        }
        
        for(ArrayList<Integer> l:forest.values()) {
            Collections.sort(l);
            result.add(l);
        }
        return result;
    }
    
    void dfs(Set<DirectedGraphNode> visited,DirectedGraphNode node,ArrayList<DirectedGraphNode> nodes) {
    	if (!visited.contains(node)) { 
    		visited.add(node);
    		DJSetNode cur = makeSet();  // initialize a tree with only one node 
    		map.put(node,cur);
	        for (DirectedGraphNode n:node.neighbors) {
	            dfs(visited,n,nodes);
	            
	            //Find a component for node to merge with
	            if(map.containsKey(n)) {
	                // merge and return the root of the new tree
	            	cur = merge(cur, map.get(n));  
	                // update root for both n and node
	                map.put(n,cur);
	                map.put(node,cur);
	            }
	        }
	        forest.get(find(cur)).add(node.label); //only root has list of labels
    	}
    }
}
