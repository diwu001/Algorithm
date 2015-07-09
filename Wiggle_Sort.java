//对数组排序，使得 a1 <= a2 >= a3 <= a4 >=...
public class Wiggle_Sort {
	//Time complexity: O(n)
	public static void wiggleSort(int[] a) {
		int n=a.length;
		int cur=a[0];
		boolean flag=true;  //current should < a[i+1]
		for(int i=0;i<n-1;i++) {
			if( (flag&&cur>a[i+1]) || (!flag&&cur<a[i+1]) ){
				a[i]=a[i+1];				
			} else {
				a[i]=cur;
				cur=a[i+1];
			}
			flag=!flag;
		}
		a[n-1]=cur;
		for(int num:a) System.out.print(num+" ");
	}
	public static void main(String[] args) {
		int[] a = {6,5,4,1,2,8,3};
		wiggleSort(a);
	}
}
