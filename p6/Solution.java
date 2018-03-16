public class Solution {
    public String convert(String s, int numRows) {
        if(s==null || s.length()==0){
            return "";
        }
        if(numRows<=1){
            return s;
        }
        int len = s.length();
        int[] gap = new int[numRows];
        for(int i=0;i<numRows;i++){
            gap[i] = 2*(numRows-i-1);
        }
        gap[numRows-1] = gap[0];
        char[] result = new char[len];
        int index = 0;
        int j = 0;
        boolean flag = true;
        for(int i=0;i<numRows;i++){
            j = i;
            flag = true;
            while(j<len){
                result[index++] = s.charAt(j);
                if(flag){
                    j += gap[i];
                    flag = false;
                }else{
                    j += gap[numRows-i-1];
                    flag = true;
                }
            }
        }
        return new String(result);
    }
}
