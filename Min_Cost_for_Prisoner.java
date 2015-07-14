import java.util.HashSet;
import java.util.Set;
 
/* Many prisoners are grouped by handcuffs, For example total number of prisoner is 5; there connections are {{0,1}, {0,2}, {2,4}};
   There are 4 prisoners in the same group {0,1,2,4}; in another group there is only 1 prisoner {3}, so the total cost is 4*4 + 1*1 =17
   Solution: union find*/
public class Min_Cost_for_Prisoner {
	static class DJSetNode {
	    int rank; 
	    DJSetNode parent;
	    int val;
	    int count;
	    public DJSetNode(int r) {
	        rank=r;
	    }
	}

	static Set<DJSetNode> forest = new HashSet<DJSetNode>();
	
	static DJSetNode makeSet(int i) {
	    DJSetNode cur = new DJSetNode(0);    
	    cur.val=i;  
	    cur.count=1; 
	    forest.add(cur);
	    return cur;
	}
	
	static DJSetNode find(DJSetNode n) {
	    if (n == null) return n;
	    while (n.parent!=null) {
	        n = n.parent;
	    }
	    return n;
	}
	
	static DJSetNode merge(DJSetNode n1, DJSetNode n2) {
	    DJSetNode r1 = find(n1);   
	    DJSetNode r2 = find(n2);
	    if (r1 == r2) return r1; 
	
	    if (r1.rank > r2.rank) {  
	        r2.parent = r1;     
	        r1.count+=r2.count;
	        forest.remove(r2);       
	        return r1;              
	    }
	    else if (r1.rank < r2.rank) { 
	        r1.parent = r2;
	        r2.count+=r1.count;
	        forest.remove(r1);
	        return r2;
	    }
	    else {                      
	        r2.parent = r1;   
	        r1.count+=r2.count;
	        forest.remove(r2);
	        r1.rank=r1.rank+1;             
	        return r1;
	    }
	}
	
	public static int minCost(int n, int[][] edges) {
		DJSetNode[] nodes = new DJSetNode[n];
		for(int i=0;i<n;i++) {
			nodes[i] = makeSet(i); 
		}
		for(int i=0;i<edges.length;i++) {
			int from=edges[i][0], to=edges[i][1];
			merge(nodes[from],nodes[to]);
		}
		int cost=0;
		if(forest.size()==1) return n*n;
		for(DJSetNode root:forest) {
			cost += root.count*root.count;
		}
		return cost;
	}
		
	public static void main(String[] args) {//undirected graph
		int n1 = 5; 
		int[][] edgeSet1 = {{0,1}, {0,2}, {2,4}};
		System.out.println(minCost(n1,edgeSet1));  //17 
		
		/*int n2 = 5; 
		int[][] edgeSet2 = {{0,1}, {1,2}, {0,2}, {2,3}, {2,4}};
		System.out.println(minCost(n2,edgeSet2)); //25 */
		
		/*int n3 = 4; 
		int[][] edgeSet3 = {{0,1}, {0,3}};		//{0,1,3} {2}
		System.out.println(minCost(n3,edgeSet3));  //10 */
	}
}
