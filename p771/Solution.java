class Solution {
    public int numJewelsInStones(String J, String S) {
        boolean[] letterMap = new boolean[52];
        int index = -1;
        char c = 'a';
        for(int i=0; i<J.length(); i++){
            c = J.charAt(i);
            index = c-'a'>=0 ? c-'a' : c-'A'+26;
            letterMap[index] = true;
        }

        int count = 0;
        for(int i=0; i<S.length(); i++){
            c = S.charAt(i);
            index = c-'a'>=0 ? c-'a' : c-'A'+26;
            if(letterMap[index]){
                count++;
            }
        }
        return count;
    }
}
