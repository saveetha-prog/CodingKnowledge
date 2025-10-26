#include <vector>
#include <numeric> 
class Bank {
private:
    std::vector<long long> balance;
    int numAccounts;
    bool isValidAccount(int account) {
        return account >= 1 && account <= numAccounts;
    }
public:
    Bank(std::vector<long long>& balance) {
        this->balance = balance;
        this->numAccounts = balance.size();
    }
    bool transfer(int account1, int account2, long long money) {
        if (!isValidAccount(account1) || !isValidAccount(account2)) {
            return false;
        }
        int idx1 = account1 - 1;
        int idx2 = account2 - 1;
        if (balance[idx1] < money) {
            return false;
        }
        balance[idx1] -= money;
        balance[idx2] += money;
        return true;
    }
    bool deposit(int account, long long money) {
        if (!isValidAccount(account)) {
            return false;
        }
        int idx = account - 1;
        balance[idx] += money;
        return true;
    }
    bool withdraw(int account, long long money) {
        if (!isValidAccount(account)) {
            return false;
        }
        int idx = account - 1;
        if (balance[idx] < money) {
            return false;
        }
        balance[idx] -= money;
        return true;
    }
};