public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null){
            return 0;
        }
        int len = s.length();
        if(len==0){
            return 0;
        }
        if(len==1){
            return 1;
        }
        int[] pos = new int[256];
        for(int i=1;i<256;i++){
            pos[i] = -1;
        }
        int start = 0;
        int index = -1;
        int max = 0;
        int curlen = 0;
        for(int i=0;i<len;i++){
            index = (int)s.charAt(i);
            if(pos[index]<start){
                pos[index] = i;
            }else{
                curlen = i-start;
                start = pos[index]+1;
                pos[index] = i;
                if(curlen>max){
                    max = curlen;
                }
            }
        }
        int last = len-start;
        max = max>last?max:last;
        return max;
    }
}
