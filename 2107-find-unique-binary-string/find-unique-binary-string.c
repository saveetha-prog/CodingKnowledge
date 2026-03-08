#include <stdlib.h>
#include <string.h>

char* findDifferentBinaryString(char** nums, int numsSize) {
    int n = numsSize;
    char* ans = (char*)malloc((n + 1) * sizeof(char));
    if (!ans) {
        return NULL; 
    }
    ans[n] = '\0';
    for (int i = 0; i < n; i++) {
        char curr = nums[i][i];
        if (curr == '0') {
            ans[i] = '1';
        } else {
            ans[i] = '0';
        }
    }
    return ans;
}

