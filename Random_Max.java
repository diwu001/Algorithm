import java.util.Random;

/* There are many maximum values in the array. Randomly return one of their index */
public class Random_Max {
	// O(3n)
	public static int randMax1(int[] a) {
		int max = a[0], count = 0;
		for(int i = 1; i < a.length; i++) {
			if(a[i] > max) {
				max = a[i];
			}
		}
		for(int i = 0; i < a.length; i++) {
			if(a[i] == max) count++;
		}
		
		Random rand = new Random();
		int id = rand.nextInt(count);
		int i = 0; 
		count = 0;
		for(; i < a.length; i++) {
			if(a[i] == max) {				
				if(count == id) break;
				count++;				
			}
		}
		return i;
	}
	
	// O(n)
	public static int randMax2(int[] a){
        int maxIdx = 0;
        int count = 1;
        for(int i = 1; i < a.length; i++){
            if(a[i] > a[maxIdx]){
                maxIdx = i;
                count = 1;
            } else if(a[i] == a[maxIdx]){    
                count++;
                Random rand = new Random();
                int r = rand.nextInt(count);                
                if(r == 0)  maxIdx = i;
            }
        }
        return maxIdx;
    }
	
	public static void main(String[] args) {
		int[] a = {1, 2, -4, 5, 1, -6, -3, 5, 5, 2, 3};
		randMax1(a);
		randMax2(a);
	}
}
