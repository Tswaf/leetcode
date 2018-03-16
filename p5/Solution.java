public class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length()==0){
            return "";
        }
        int max = 0;
        int count = 0;
        int[] result = new int[2];
        int[] index = new int[2];
        for(int i=0;i<s.length()-1;i++){
            count = longestOne(s,i,index);
            if(count>max){
                max = count;
                result[0] = index[0];
                result[1] = index[1];
            }
            count = longestTwo(s,i,index);
            if(count>max){
                max = count;
                result[0] = index[0];
                result[1] = index[1];
            }
        }
        return s.substring(result[0],result[1]+1);
    }
    private int longestOne(String s,int pos,int[] index){
        int count = 1;
        int i= pos-1;
        int j = pos+1;
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            count+=2;
            j++;
            i--;
        }
        index[0] = i+1;
        index[1] = j-1;
        return count;
    }
    private int longestTwo(String s,int pos,int[] index){
        if(s.charAt(pos)!=s.charAt(pos+1)){
            return 0;
        }
        int count = 2;
        int i = pos-1;
        int j = pos+2;
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            count+=2;
            j++;
            i--;
        }
        index[0] = i+1;
        index[1] = j-1;
        return count;
    }
}
