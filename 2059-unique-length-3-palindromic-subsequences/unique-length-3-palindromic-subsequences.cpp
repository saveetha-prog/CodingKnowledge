#include <iostream>
#include <string>
#include <unordered_set>
#include <unordered_map>
#include <vector>
#include <algorithm>

class Solution {
public:
    int countPalindromicSubsequence(std::string s) {
        std::vector<int> first_idx(26, -1);
        std::vector<int> last_idx(26, -1);

        for (int i = 0; i < s.length(); ++i) {
            int char_idx = s[i] - 'a';
            if (first_idx[char_idx] == -1) {
                first_idx[char_idx] = i;
            }
            last_idx[char_idx] = i;
        }
        int count = 0;
        for (int i = 0; i < 26; ++i) {
            if (first_idx[i] != -1 && last_idx[i] != -1) {
                int left = first_idx[i];
                int right = last_idx[i];
                if (right - left > 1) {
                    std::unordered_set<char> unique_middle_chars;
                    for (int j = left + 1; j < right; ++j) {
                        unique_middle_chars.insert(s[j]);
                    }
                    count += unique_middle_chars.size();
                }
            }
        }
        return count;
    }
};
