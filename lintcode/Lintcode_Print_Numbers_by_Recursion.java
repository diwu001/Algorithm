//http://www.lintcode.com/en/problem/print-numbers-by-recursion/
import java.util.*;
//Given N = 2, return [1,2,3,4,5,6,7,8,9,10,11,12,...,99].
public class Lintcode_Print_Numbers_by_Recursion {
	//DFS
	public List<Integer> numbersByRecursion(int n) {
        List<Integer> result = new ArrayList<Integer>();
        helper(result,n,0);
        Collections.sort(result);  //[1,10,11,...,19,2,20,21,....99] needs to sort
        return result;
    }
    
    public void helper(List<Integer> result, int n, int k){
        if(n==0) {
            return;
        }
        for(int i=0;i<=9;i++) {
            if(result.size()==0&&i==0) continue;
            result.add(k*10+i);
            helper(result,n-1,k*10+i);
        }
    }
//-------------------------------------------------------------    
    public List<Integer> numbersByRecursion2(int n) {
        List<Integer> result = new ArrayList<Integer>();
        helper2(result,n);
        return result;
    }
    
    // n=0, base=1; 
    // n=1 size=0 curbase=1,2,..9  base=10; 
    // n=2 size=9 curbase=10 -> 11,12,..,19 curbase=20 -> 21,22,29 ....curbase=90 -> 91,92,..,99 base=100 return
    public int helper2(List<Integer> result, int n){
        if(n==0) {
            return 1;
        }
        int base = helper2(result,n-1);  
        int size=result.size();
        for(int i=1;i<=9;i++) {
            int curbase = i*base;
            result.add(curbase);
            for(int j=0;j<size;j++) {
                result.add(curbase+result.get(j));
            }
        }
        return base*10;
    }
}
