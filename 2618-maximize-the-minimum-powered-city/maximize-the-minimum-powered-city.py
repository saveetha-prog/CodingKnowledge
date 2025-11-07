class Solution(object):
    def maxPower(self, stations, r, k):
        """
        :type stations: List[int]
        :type r: int
        :type k: int
        :rtype: int
        """
        n = len(stations)
        power = [0] * n
        prefix = [0] * (n + 1)
        for i in range(n):
            prefix[i + 1] = prefix[i] + stations[i]
        for i in range(n):
            left = max(0, i - r)
            right = min(n - 1, i + r)
            power[i] = prefix[right + 1] - prefix[left]
        left, right, ans = 0, 10**18, 0
        while left <= right:
            mid = (left + right) // 2
            if self.canAchieve(power, r, k, mid):
                ans = mid
                left = mid + 1
            else:
                right = mid - 1
        return ans
    def canAchieve(self, power, r, k, target):
        n = len(power)
        added = [0] * n
        used = 0
        window = 0
        for i in range(n):
            if i - r - 1 >= 0:
                window -= added[i - r - 1]
            curr = power[i] + window   
            if curr < target:
                need = target - curr
                used += need
                if used > k:
                    return False
                add_pos = min(n - 1, i + r)
                added[add_pos] += need
                window += need 
        return True

        