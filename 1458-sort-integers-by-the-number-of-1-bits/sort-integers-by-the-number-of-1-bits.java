import java.util.Arrays;

class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(nums, (a, b) -> {
            int bitCountA = Integer.bitCount(a);
            int bitCountB = Integer.bitCount(b);
            if (bitCountA == bitCountB) {
                return a - b; 
            }
            return bitCountA - bitCountB; 
        });
        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
    }
}
