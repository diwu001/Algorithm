import java.util.Random;
// In　O(n) time, shuffle an array randomly
// for each i, j is chosen in the range of [i,n-1], then swap a[i] and a[j]
public class Shuffle_Array {
	public static void main(String[] args) {
		int[] a ={1,2,3,4,5,6};

		for(int i=0;i<a.length-1;i++) {
			Random r = new Random();
			int j = i+r.nextInt(a.length-i);
			int temp=a[i];
			a[i]=a[j];
			a[j]=temp;
		}
		
		for(int i=0;i<a.length;i++) System.out.println(a[i]);
	}
}
