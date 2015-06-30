import java.util.*;
public class Word_Bread_using_DFS {
	public static void printLongestWord(ArrayList<String> arr) {
	    Comparator<String> c = new Comparator<String>(){
	    	public int compare(String a, String b) {
	    		return b.length() - a.length();
	    	}
	    };
		Collections.sort(arr, c);  //sort arr by string length in descending order
	    HashSet<String> set = new HashSet<String>();
	    for (String str : arr) {
	        set.add(str);
	    }
	    for (String word : arr) {
	        if (canDivide(word, 0, set)) {
	            System.out.println(word);
	            return;
	        }
	    }
	    System.out.println("can not find such word");
	}

	private static boolean canDivide(String word, int from, HashSet<String> set) {
	    if (from == word.length()) {
	        return true;
	    }
	    for (int i = from; i < word.length(); i++) {
	        String str = word.substring(from, i + 1);
	        if (from == 0 && i == word.length() - 1) {
	            continue;
	        } else if (!set.contains(str)) {
	            continue;
	        }
	        if (canDivide(word, i + 1, set)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public static void main(String[] args){
		ArrayList<String> ss = new ArrayList<String>();
		ss.add("cat");
		ss.add("cats");
	    ss.add("catsdogcats");
	    ss.add("catxdogcatsrat");
	    ss.add("dog");
	    ss.add("dogcatsdog");
	    ss.add("hippopotamuses");
	    ss.add("rat");
	    ss.add("ratcatdogcat");
	    printLongestWord(ss);	    
	}
}
