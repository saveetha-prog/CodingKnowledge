class Solution {
    public boolean isPalindrome(String s) {
        String clean="";
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                clean=clean+Character.toLowerCase(ch);
            }
        }
        int i=0;
        int j=clean.length()-1;
        while(i<j){
            if(clean.charAt(i)!=clean.charAt(j))
            return false;
        i++;
        j--;
        }
        return true;
    }
}