#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    long long endTime;
    int roomId;
} Room;
int compareMeetings(const void* a, const void* b) {
    int startA = (*(int**)a)[0];
    int startB = (*(int**)b)[0];
    return (startA > startB) - (startA < startB);
}

int mostBooked(int n, int** meetings, int meetingsSize, int* meetingsColSize) {
    qsort(meetings, meetingsSize, sizeof(int*), compareMeetings);

    long long* roomEndTimes = (long long*)calloc(n, sizeof(long long));
    int* meetingCount = (int*)calloc(n, sizeof(int));

    for (int i = 0; i < meetingsSize; i++) {
        int start = meetings[i][0];
        int end = meetings[i][1];
        int duration = end - start;
        
        int bestRoom = -1;
        long long earliestEndTime = 9223372036854775807LL; 
        int foundAvailable = 0;
        for (int j = 0; j < n; j++) {
            if (roomEndTimes[j] <= start) {
                bestRoom = j;
                foundAvailable = 1;
                break;
            }
            if (roomEndTimes[j] < earliestEndTime) {
                earliestEndTime = roomEndTimes[j];
                bestRoom = j;
            }
        }

        if (foundAvailable) {
            roomEndTimes[bestRoom] = end;
        } else {
            roomEndTimes[bestRoom] += duration;
        }
        meetingCount[bestRoom]++;
    }

    int maxMeetings = 0;
    int resultRoom = 0;
    for (int i = 0; i < n; i++) {
        if (meetingCount[i] > maxMeetings) {
            maxMeetings = meetingCount[i];
            resultRoom = i;
        }
    }

    free(roomEndTimes);
    free(meetingCount);
    return resultRoom;
}
