#include <stdio.h>
#include <stdlib.h>
int compare(const void *a, const void *b) {
    return (*(int*)b - *(int*)a);
}
long long maximumHappinessSum(int* happiness, int happinessSize, int k) {
    qsort(happiness, happinessSize, sizeof(int), compare);
    long long totalHappiness = 0;
    int decrement = 0;
    for (int i = 0; i < k; i++) {
        int currentHappiness = happiness[i] - decrement;
        if (currentHappiness > 0) {
            totalHappiness += currentHappiness;
        } else {
            break;
        }
        decrement++;
    }
    return totalHappiness;
}
