/*Write a function to calculate x * 7 without using + - / * %.

x * 7 = x * 4 + x * 2 + x
= (x << 2) + (x << 1) + x
= add(x << 2, add(x << 1, x)) */
public class XTimes7 {
	public static int add(int a, int b) {
		while(b!=0) {
			int carry=a&b;
			a=a^b;
			b=carry<<1;
		}
		return a;
	}
	
	public static void main(String[] args) {
		int x=3;
		int temp=add(x,x<<1);
		int result=add(temp,x<<2);
		System.out.println(result);  //21
	}
}
