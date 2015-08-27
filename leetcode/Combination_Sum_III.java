import java.util.*;
public class Combination_Sum_III {
	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(n>45) return result;
        List<Integer> path = new ArrayList<Integer>();
        dfs(result,path,k,n,0,1);
        return result;
    }
    
    public void dfs(List<List<Integer>> result,List<Integer> path,int k, int n, int sum, int pos) {
        if(k==0) {
            if(sum==n) result.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i=pos;i<=9;i++) {
            if(sum>=n) return;
            path.add(i);
            dfs(result,path,k-1,n,sum+i,i+1);
            path.remove(path.size()-1);
        }
    }
}
