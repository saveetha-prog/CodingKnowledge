import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        for (int num : nums) {
           
            List<Integer> temp = new ArrayList<>();
            while (num > 0) {
                temp.add(num % 10); 
                num /= 10;         
            }
            
            for (int i = temp.size() - 1; i >= 0; i--) {
                result.add(temp.get(i));
            }
        }
        
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        
        return ans;
    }
}