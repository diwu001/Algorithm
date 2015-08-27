package clone_graph;

import java.util.HashMap;
import java.util.LinkedList;

/*public class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}
*/

public class Clone_Graph {
	// BFS
	public UndirectedGraphNode cloneGraphBFS(UndirectedGraphNode node) {
        if(node==null) return node;
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        queue.offer(node);
        map.put(node,copy);
        while(!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            for(int i=0;i<cur.neighbors.size();i++) {
                if(!map.containsKey(cur.neighbors.get(i))) {
                    copy = new UndirectedGraphNode(cur.neighbors.get(i).label);
                    map.put(cur.neighbors.get(i),copy);
                    queue.offer(cur.neighbors.get(i));
                }
                map.get(cur).neighbors.add(map.get(cur.neighbors.get(i)));
            }
        }
        return map.get(node);
    }
	
	// DFS
	public UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node) {
        if(node==null) return node;
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        LinkedList<UndirectedGraphNode> stack = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        stack.push(node);
        map.put(node,copy);
        while(!stack.isEmpty()) {
            UndirectedGraphNode cur = stack.pop();
            for(int i=0;i<cur.neighbors.size();i++) {
                if(!map.containsKey(cur.neighbors.get(i))) {
                    copy = new UndirectedGraphNode(cur.neighbors.get(i).label);
                    map.put(cur.neighbors.get(i),copy);
                    stack.push(cur.neighbors.get(i));
                }
                map.get(cur).neighbors.add(map.get(cur.neighbors.get(i)));
            }
        }
        return map.get(node);
    }
}
