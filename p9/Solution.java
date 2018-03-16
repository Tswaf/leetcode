public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int org = x;
        int result = 0;
        while(org>0){
            result *= 10;
            result += org%10;
            org /= 10;
        }
        return result==x;
    }
}
