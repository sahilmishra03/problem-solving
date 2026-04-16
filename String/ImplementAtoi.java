class Solution {
    public int myAtoi(String s) {
        boolean isPos = true;
        long finalValue = 0;
        for (int i = 0; i < s.length(); i = i + 1) {
            if (s.charAt(i) == '-') {
                isPos = false;
            }
            int intValueChar = s.charAt(i);
            if (intValueChar >= 48 && intValueChar <= 57) {
                finalValue = (long)(finalValue * 10) + Long.parseLong(String.valueOf(s.charAt(i)));
            }
            
            if((intValueChar >=65 && intValueChar<=90)||(intValueChar >=97 && intValueChar<=122)) break;
        }
        if (!isPos) {
            finalValue=finalValue*-1;
        }
        
        // -2,147,483,648 to 2,147,483,647
            if(finalValue>=2147483647){
                return 2147483647;
            }
            
            if(finalValue<=-2147483647){
                return -2147483648;
            }
        return (int)finalValue;
    }
}