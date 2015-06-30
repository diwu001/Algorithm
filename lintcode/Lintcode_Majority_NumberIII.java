/*Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/k ⌋ times. 
 * You may assume that the array is non-empty and the majority element always exist in the array.*/

package majority_numberIII;

import java.util.ArrayList;
import java.util.HashMap;

public class Lintcode_Majority_NumberIII {
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        if (nums == null || nums.size() == 0 || k > nums.size()) {  
            return -1;  
        }  
          
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();  
        for (int i = 0; i < nums.size(); i++) {  
            if (map.containsKey(nums.get(i))) {  
                map.put(nums.get(i), map.get(nums.get(i)) + 1);  
            } else if (map.size() < k) {  
                map.put(nums.get(i), 1);  
            } else {  
                ArrayList<Integer> keys = new ArrayList<Integer>();  
                for (Integer key : map.keySet()){  
                    keys.add(key);  
                }  
                for (Integer key : keys) {  
                    map.put(key, map.get(key) - 1);  
                    if (map.get(key) == 0) {  
                        map.remove(key);  
                    }  
                }  
            }  
        }  

        for (Integer val : map.values()) val=0;
        for(int i=0; i < nums.size(); i++) {
            if(map.containsKey(nums.get(i))) map.put(nums.get(i),map.get(nums.get(i)) + 1);
        }    
        
        int res = 0, num = 0;  
        for (Integer key : map.keySet()) {  
            if (num < map.get(key)) {  
                num = map.get(key);  
                res = key;  
            }  
        }  
          
        return res; 
    }
}
