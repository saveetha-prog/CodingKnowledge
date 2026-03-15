import java.util.ArrayList;
import java.util.List;

class Fancy {
    private List<Long> numbers;
    private long add;
    private long mult;
    private final long MOD = 1_000_000_007;

    public Fancy() {
        numbers = new ArrayList<>();
        add = 0;
        mult = 1;
    }

    public void append(int val) {
        long originalVal = (long) val;
        long sub = (originalVal - add) % MOD;
        if (sub < 0) {
            sub += MOD;
        }

        long multInverse = modPow(mult, MOD - 2);
        long trueVal = (sub * multInverse) % MOD;

        numbers.add(trueVal);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        mult = (mult * m) % MOD;
        add = (add * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= numbers.size()) {
            return -1;
        }
        long baseVal = numbers.get(idx);
        long result = (baseVal * mult + add) % MOD;
        return (int) result;
    }
    private long modPow(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }
}
