#include <stdio.h>
#include <string.h>
#include <math.h>

#define MIN(a, b) ((a) < (b) ? (a) : (b))

int minFlips(char * s) {
    int n = strlen(s);
    int diff1 = 0, diff2 = 0;
    int min_flips = n;
    for (int i = 0; i < 2 * n; ++i) {
        if (s[i % n] != (i % 2 == 0 ? '0' : '1')) diff1++;
        if (s[i % n] != (i % 2 == 0 ? '1' : '0')) diff2++;
        if (i >= n) {
            if (s[(i - n) % n] != ((i - n) % 2 == 0 ? '0' : '1')) diff1--;
            if (s[(i - n) % n] != ((i - n) % 2 == 0 ? '1' : '0')) diff2--;
        }
        if (i >= n - 1) {
            min_flips = MIN(min_flips, MIN(diff1, diff2));
        }
    }
    return min_flips;
}
