#include <string.h>
int bestClosingTime(char * customers) {
    int cur_score = 0;
    int max_score = 0;
    int best_hour = 0;
    for (int i = 0; customers[i] != '\0'; i++) {
        if (customers[i] == 'Y') {
            cur_score++;
        } else {
            cur_score--;
        }
        if (cur_score > max_score) {
            max_score = cur_score;
            best_hour = i + 1;
        }
    }
    return best_hour;
}
