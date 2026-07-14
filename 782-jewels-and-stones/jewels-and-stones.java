class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set=new HashSet<>();
        int count=0;
        for(char ch:jewels.toCharArray()){
            set.add(ch);
        }
        for(char cha:stones.toCharArray()){
            if(set.contains(cha)){
                count++;
            }
        }
        return count;
    }
}