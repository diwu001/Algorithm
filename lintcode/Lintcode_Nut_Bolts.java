public class Lintcode_Nut_Bolts {
	static class NBComparator {
		public int cmp(String a, String b) {
			/** You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
			 * if "a" is bigger than "b", it will return 1, else if they are equal,
			 * it will return 0, else if "a" is smaller than "b", it will return -1.
			 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
			*/
			return a.compareTo(b);
		}
	}
	
	public static void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        if(nuts==null||bolts==null||nuts.length!=bolts.length) return;
        helper(nuts, bolts, compare, 0, nuts.length-1);
    }
    
    public static void helper(String[] nuts, String[] bolts, NBComparator compare, int low, int high) {
        if(low>high) return;
        int pivot = partition1(nuts,compare,low,high,bolts[high]);
        partition2(bolts,compare, low,high,nuts[pivot]);
        helper(nuts, bolts, compare, low, pivot-1);
        helper(nuts, bolts, compare, pivot+1, high);
    }
    
    public static int partition1(String[] ss, NBComparator compare, int low, int high, String key){
        int i=low;
        for(int j=low;j<high;j++) {    
                if(compare.cmp(ss[j],key)==-1) {
                    String temp=ss[j];
                    ss[j]=ss[i];
                    ss[i]=temp;
                    i++;
                } else if(compare.cmp(ss[j],key)==0) {
                    String temp=ss[j];
                    ss[j]=ss[high];
                    ss[high]=temp;
                    j--;
                } 
            
        }
        String temp=ss[i];
        ss[i]=ss[high];
        ss[high]=temp;
        return i;
    }
    public static int partition2(String[] ss, NBComparator compare, int low, int high, String key){
        int i=low;
        for(int j=low;j<high;j++) {
          
                if(compare.cmp(key,ss[j])==1) {
                    String temp=ss[j];
                    ss[j]=ss[i];
                    ss[i]=temp;
                    i++;
                } else if(compare.cmp(key,ss[j])==0) {
                    String temp=ss[j];
                    ss[j]=ss[high];
                    ss[high]=temp;
                    j--;
                } 
            
        }
        String temp=ss[i];
        ss[i]=ss[high];
        ss[high]=temp;
        return i;
    }
    
    public static void main(String[] args) {
    	String[] nuts={"ab","bc","dd","gg"};
    	String[] bolts={"ab","gg","dd","bc"};
    	NBComparator compare = new NBComparator();
    	sortNutsAndBolts(nuts, bolts, compare);
    }
}
