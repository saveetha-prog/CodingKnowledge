class Solution {
    public int[] findEvenNumbers(int[] digits) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 100; i <= 998; i += 2) {
            int num = i;

            int a = num / 100;          // hundreds digit
            int b = (num / 10) % 10;    // tens digit
            int c = num % 10;           // ones digit

            int[] count = new int[10];

            for (int d : digits) {
                count[d]++;
            }

            if (count[a] > 0) {
                count[a]--;

                if (count[b] > 0) {
                    count[b]--;

                    if (count[c] > 0) {
                        list.add(num);
                    }
                }
            }
        }
        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}