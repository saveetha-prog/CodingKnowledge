bool checkOnesSegment(char * s) {
    for (int i = 1; s[i] != '\0'; i++) {
        if (s[i] == '1' && s[i - 1] == '0') {
            return false;
        }
    }
    return true;
}
