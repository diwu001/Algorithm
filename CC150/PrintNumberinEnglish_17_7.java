/*Given any integer, print an English phrase that describes the integer
1234: One Thousand, Two　Hundred Thirty four*/
public class PrintNumberinEnglisth_17_7 {
	static String[] digits = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	static String[] teens = {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	static String[] tens = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	static String[] bigs = {"", "Thousand", "Million", "Billion"};
	
	static String numToString(int number) {
		if (number == 0) return "Zero";				
		if (number < 0) return "Negative " + numToString(-1 * number);
		
		int count = 0;
		String str = "";
		
		while (number > 0) {
			if (number % 1000 != 0) {
				str = numToString100(number % 1000) + bigs[count] + " " + str;
			}
			number /= 1000;
			count++;
		}		
		return str;
	}
	
	static String numToString100(int number) {	//number [1-999]
		String str = "";		
		if (number >= 100) {
			str += digits[number / 100 - 1] + " Hundred ";
			number %= 100;
		}		
		if (number >= 11 && number <= 19) {
			return str + teens[number - 11] + " ";
		} else if (number == 10 || number >= 20) {
			str += tens[number / 10 - 1] + " ";
			number %= 10;
		}		
		if (number >= 1 && number <= 9) {
			str += digits[number - 1] + " ";
		}		
		return str;
	}
	
	public static void main(String[] args) {	
		System.out.println(numToString(1212341234));
	}
}
