package heap_sort;

import java.util.Arrays;

public class Heap_Sort {
	protected double A[];
	protected int heapsize;
	//constructors
	public Heap_Sort(){}
	public Heap_Sort(double A[]){
		buildMaxHeap(A);
	}
	
	protected  int parent(int i) {return (i - 1) / 2;}
	protected  int left(int i) {return 2 * i + 1;}
	protected  int right(int i) {return 2 * i + 2;}
	
	protected void maxHeapify(int i){
		int l = left(i);
		int r = right(i);
		int largest = i;
		if (l <= heapsize-1 && A[l] > A[i])
		largest = l;
		if (r <= heapsize-1 && A[r] > A[largest])
		largest = r;
		if (largest != i) {
		double temp = A[i];
		// swap
		A[i] = A[largest];
		A[largest] = temp;
		maxHeapify(largest);
		}
	}
	
	public void buildMaxHeap(double [] A){
		this.A = A;
		heapsize = A.length;
		for (int i = parent(heapsize-1); i >= 0; i--)
		maxHeapify(i);
	}
	
	public void sort(double [] A){
		buildMaxHeap(A);
		int step = 1;
		for (int i = A.length-1; i > 0; i--) {
			double temp = A[i];
			A[i] = A[0];
			A[0] = temp;
			heapsize--;
			System.out.println((step++) + Arrays.toString(A));
			maxHeapify(0);
		}
	}
	
	public static void main(String[] args) {
		double [] A = {3, 7, 2, 11, 3, 4, 9, 2, 18, 0};
		System.out.println(Arrays.toString(A));
		Heap_Sort maxhp = new Heap_Sort();
		maxhp.sort(A);
		System.out.println(Arrays.toString(A));
		}
}
