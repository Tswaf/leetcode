public class Solution {
     public int myAtoi(String str) {
	        if(str==null || str==""){
	            return 0;
	        }
	        int n = str.length();
	        //skip blank
	        int i = 0;
	        while(i<n && str.charAt(i)==' '){
	            i++;
	        }
	        if(i==n){
	            return 0;
	        }
	        boolean positive = true;
	        int start = i;
	        
	        //get sign
	        if(str.charAt(i)=='-'){
	            positive = false;
	            i++;
	            start = i;
	        }else if(str.charAt(i)=='+'){
	            positive = true;
	            i++;
	            start = i;
	        }else if(str.charAt(i)<'0' ||str.charAt(i)>'9'){ //invalid
	            return 0;
	        }
	        
	        //get number
	        while(start<n && str.charAt(start)=='0'){ //ingore prefix zeros
	            start++;
	        }
	        i = start;
	        while(i<n && str.charAt(i)>='0' && str.charAt(i)<='9'){
	            i++;
	        }
	        String number = str.substring(start,i);
	        if(number.equals("")){
	            return 0;
	        }
	        if(positive){
	           return pos(number);
	        }else{
	        	return neg(number);
	        }
	    }
	    private int pos(String number){
	        int result = 0;
	        int n = number.length();
	        int i = 0;
	        int add = 0;
	        while(i<n){
	            if(Integer.MAX_VALUE/10<result){
	                return Integer.MAX_VALUE;
	            }
	            result *= 10;
	            add = number.charAt(i)-'0';
	            if(Integer.MAX_VALUE-add<result){
	                return Integer.MAX_VALUE;
	            }
	            result += number.charAt(i)-'0';
	            i++;
	        }
	        return result;
	    }
	    private int neg(String number){
	        int result = 0;
	        int n = number.length();
	        int i = 0;
	        int add = 0;
	        while(i<n){
	            if(Integer.MIN_VALUE/10>result){
	                return Integer.MIN_VALUE;
	            }
	            result *= 10;
	            add = number.charAt(i)-'0';
	            if(Integer.MIN_VALUE+add>result){
	                return Integer.MIN_VALUE;
	            }
	            result -= number.charAt(i)-'0';
	            i++;
	        }
	        return result;
	    }
}
