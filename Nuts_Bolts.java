/*The problem also known as Keys and locks
 * Given a set of n nuts of different sizes and n bolts of different sizes. 
 * There is a one-one mapping between nuts and bolts. Match nuts and bolts efficiently.
 * Constraint: Comparison of a nut to another nut or a bolt to another bolt is not allowed. 
 * It means nut can only be compared with bolt and bolt can only be compared with nut to see which one is bigger/smaller. 
 * e.g. int[] a=[3,4,1,2], int[] b=[2,1,3,4] -> a=[1,2,3,4], b=[1,2,3,4]*/
public class Nuts_Bolts {
	//Θ(nlogn) on average
	public static void sort(int[] a, int[] b) {
		if(a==null||a.length==0||b==null||b.length==0||a.length!=b.length) return;
		int m=a.length;
		helper(a,b,0,m-1);
		for(int i=0;i<m;i++) System.out.print(a[i]+" ");
		System.out.println();
		for(int i=0;i<m;i++) System.out.print(b[i]+" ");
	}
	
	public static void helper(int[] a, int[] b, int low, int high) {		
		if(low>=high) return;
		int pivot = partition(a,low,high,b[high]);
		partition(b,low,high,a[pivot]);
		helper(a,b,low,pivot-1);
		helper(a,b,pivot+1,high);		
	}
	
	public static int partition(int[] a, int low, int high, int pivot) {
		int i = low;
        
        	for (int j = low; j < high; j++) {
            		if (a[j] < pivot){
                		int temp1 = a[i];
                		a[i] = a[j];
                		a[j] = temp1;
                		i++;
        		 } else if(a[j] == pivot){
                		int temp1 = a[j];
                		a[j] = a[high]; 
                		a[high] = temp1;
                		j--;
        		 }
        	}
        	int temp1 = a[i];
        	a[i] = a[high];
        	a[high] = temp1;
 
        	// Return the partition index of an array based on the pivot element of other array.
        	return i;
	}
}
