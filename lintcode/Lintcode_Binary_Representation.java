//http://www.lintcode.com/en/problem/binary-representation/
public class Lintcode_Binary_Representation {
	/**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     */
	
	public String binaryRepresentation(String n) {  //e.g. 4.5
        if(n==null||n.length()==0) return n;
        int iPart = Integer.parseInt(n.substring(0,n.indexOf('.')));  //"4"
        double dPart = Double.parseDouble(n.substring(n.indexOf('.')));  //".5" needs to keep '.' 
        String istr="",dstr="";
        
        // Convert integer part to binary representation
        // e.g. 4 -> 0, 2 -> 0, 1 -> 1, so 4 =>100 (in reverse order)
        if(iPart==0) istr="0";
        while(iPart>0) {
            int digit=iPart%2;
            istr=digit+istr;
            iPart=iPart/2;
        }
        
        // Convert decimal part to binary representation
        // e.g. 0.5*2=1.0 dstr=1 dPart=0.0, end of while, so 0.5 => 1
        // another example: 0.75 => 11, 0.25 => 01
        while(dPart>0.0) {
            double digit=dPart*2;  
            if (digit>=1.0) {
                 dstr=dstr+'1';
                 dPart=digit-1.0;
             } else {
                 dstr=dstr+'0';
                 dPart=digit;
             }
            if(dstr.length()>32) return "ERROR";  //only restrict the length of decimal part, in case of dead loop
        }
        return dstr.length()>0?istr+"."+dstr:istr;  //so 4.5 => 100.1
    }
}
