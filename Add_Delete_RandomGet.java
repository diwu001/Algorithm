// Design a data structure that support add, delete and randomly get in O(1) time
import java.util.*;
public class Add_Delete_RandomGet {
	private List<Integer> nums = new ArrayList<Integer>();  
    // key: value in nums array;   value: index in nums array  
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();  
  
    public void add(int server) {  
        nums.add(server);  
        map.put(server, nums.size() - 1);  
    }  
  
    public void remove(int server) {  
        int index = map.get(server);  
        map.remove(server);  
        nums.set(index, nums.get(nums.size() - 1));  
        map.put(nums.get(index), index);  
        nums.remove(nums.size() - 1);  
    }  
  
    public int findRandom() {  
        if (nums.size() == 0)  
            return -1;  
        Random random = new Random();  
        int randomKey = random.nextInt(nums.size());  
        return nums.get(randomKey);  
    }  
}
