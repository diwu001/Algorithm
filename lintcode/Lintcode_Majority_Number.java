/*Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times. 
 * You may assume that the array is non-empty and the majority element always exist in the array.*/

package majority_number;

public class Lintcode_Majority_Number {
	public int majorityElement(int[] num) {
        if(num==null||num.length==0) return 0;
        int count=1,candidate=num[0];
        for(int i=1;i<num.length;i++) {
            if(count==0) {
                candidate = num[i];
                count++;
            } else {
                if(candidate==num[i]) count++;
                else count--;
            }
        }
        return candidate;
    }
}
