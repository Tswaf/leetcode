public class Solution {
    public int reverse(int x) {
        boolean negative = (x<0);
        if(x<0){
            x = -x;
        }
        int result = 0;
        while(x!=0){
            if(result>Integer.MAX_VALUE/10){
                return 0;
            }
            result *= 10;
            if(result>Integer.MAX_VALUE-x%10){
                return 0;
            }
            result += x%10;
            x /=10;
        }
        return negative?(-result):result;
    }
}
