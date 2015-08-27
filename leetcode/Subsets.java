/*Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
] */
package subsets;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {   
	// Find all subsets using DFS
	public ArrayList<ArrayList<Integer>> subsets(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        subsetsHelper(result, path, num, 0);
        return result;
    }
    
    public void subsetsHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path, int[] num, int pos) {
        result.add(new ArrayList<Integer>(path));
        if(pos==num.length) {
            return;
        }
        
        for(int i=pos;i<num.length;i++) {
            path.add(num[i]);
            subsetsHelper(result, path, num,i+1);
            path.remove(path.size()-1);
        }
    }
	
	// Find all subsets using iteration 
	/*public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        for(int i=0;i<S.length;i++) {
            int l = result.size();
            for(int j=0;j<l;j++) {
                ArrayList<Integer> newS = new ArrayList<Integer>(result.get(j));
                newS.add(S[i]);
                result.add(newS);
            }
        }
        return result;
    }*/
}

