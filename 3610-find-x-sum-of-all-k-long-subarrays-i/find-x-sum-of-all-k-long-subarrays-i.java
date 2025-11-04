class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
      int n=nums.length;
      List<Integer> result=new ArrayList<>();
      for(int i=0;i<n-k+1;i++){
        int[] subarray=Arrays.copyOfRange(nums,i,i+k);
        Map<Integer,Integer>freqMap=new HashMap<>();
        for(int num:subarray){
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }
            List<int[]>freqList=new ArrayList<>();
            for(Map.Entry<Integer,Integer>entry:freqMap.entrySet()){
                freqList.add(new int[]{ entry.getKey(),entry.getValue()});
            }
            Collections.sort(freqList,(a,b)->b[1]==a[1]?b[0]-a[0]:b[1]-a[1]);
            int xSum=0;
            for(int j=0;j<Math.min(x,freqList.size());j++){
                xSum+=freqList.get(j)[0]*freqList.get(j)[1];
            }
            result.add(xSum);
        }
        int[] answer=new int[result.size()];
        for(int i=0;i<result.size();i++){
            answer[i]=result.get(i);
        }
      return answer;
    } 
}