//http://www.lintcode.com/en/problem/sort-colors-ii/
public class Lintcode_Sort_ColorII {
	// partition 
	public void sortColors2(int[] colors, int k) {
        if(colors==null||colors.length==0) return;
        int n=colors.length;
        int i=0,j=n-1;
        for(int p=1;p<k;p++) {  //partition for k-1 times
            while(i<j) {
                while(i<j&&colors[i]<=p) i++;
                while(i<j&&colors[j]>p) j--;
                if(i<j) {
                    swap(colors,i,j);
                    i++;
                    j--;
                }
            }
            j=n-1;
        }
    }
    
    public void swap(int[] colors, int i, int j) {
        int temp=colors[i];
        colors[i]=colors[j];
        colors[j]=temp;
    }
}
