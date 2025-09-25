class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i=1;i<triangle.size();i++){
            for(int j=0;j<triangle.get(i).size();j++){
                int sum1=0;
                if(j==0){
                    sum1=triangle.get(i).get(j)+ triangle.get(i-1).get(j);
                }
                else if(j==triangle.get(i).size()-1){
                    sum1=triangle.get(i).get(j)+triangle.get(i-1).get(triangle.get(i-1).size()-1);
                }
                else{
                    int min=Math.min(triangle.get(i-1).get(j),triangle.get(i-1).get(j-1));
                    sum1=min+triangle.get(i).get(j);
                }
                triangle.get(i).set(j,sum1);
            }
        }
        return Collections.min(triangle.get(triangle.size()-1));
    }
}