import java.util.*;
public class DifferentWaystoAddParentheses {
	public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<input.length();i++) {
            if(input.charAt(i)=='+' || input.charAt(i)=='-' ||input.charAt(i)=='*') {
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1,input.length()));
                for(int j=0;j<left.size();j++) {
                    for(int k=0;k<right.size();k++) {
                        if(input.charAt(i)=='+' ) {
                            result.add(left.get(j)+right.get(k));
                        } else if(input.charAt(i)=='-') {
                            result.add(left.get(j)-right.get(k));
                        } else {
                            result.add(left.get(j)*right.get(k));
                        }
                    }
                }
            }
        }
        if(result.size()==0) result.add(Integer.valueOf(input));
        return result;
    }
}
