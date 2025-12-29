#include <stdbool.h>
#include <string.h>
int transitions[7][7];
char memo[1 << 14]; 
bool solve(char* row, char* next_row, int index) {
    int len = strlen(row);
    if (len == 1) return true;
    if (index == len - 1) {
        next_row[index] = '\0';
        return solve(next_row, (char[8]){0}, 0);
    }
    int left = row[index] - 'A';
    int right = row[index + 1] - 'A';
    int allowed_tops = transitions[left][right];
    for (int i = 0; i < 7; i++) {
        if (allowed_tops & (1 << i)) {
            next_row[index] = (char)('A' + i);
            if (solve(row, next_row, index + 1)) return true;
        }
    }
    return false;
}
bool pyramidTransition(char* bottom, char** allowed, int allowedSize) {
    memset(transitions, 0, sizeof(transitions));
    for (int i = 0; i < allowedSize; i++) {
        int u = allowed[i][0] - 'A';
        int v = allowed[i][1] - 'A';
        int w = allowed[i][2] - 'A';
        transitions[u][v] |= (1 << w);
    }
    char next_row[8] = {0};
    return solve(bottom, next_row, 0);
}
