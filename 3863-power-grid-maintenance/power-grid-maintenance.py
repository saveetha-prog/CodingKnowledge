class UnionFind:
    def __init__(self, n):
        self.parent = list(range(n+1))
        self.rank   = [0]*(n+1)
    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]
    def union(self, x, y):
        rx = self.find(x)
        ry = self.find(y)
        if rx == ry:
            return False
        if self.rank[rx] < self.rank[ry]:
            self.parent[rx] = ry
        elif self.rank[ry] < self.rank[rx]:
            self.parent[ry] = rx
        else:
            self.parent[ry] = rx
            self.rank[rx] += 1
        return True
class Solution(object):
    def processQueries(self, c, connections, queries):
        """
        :type c: int
        :type connections: List[List[int]]
        :type queries: List[List[int]]
        :rtype: List[int]
        """
        uf = UnionFind(c)
        for u, v in connections:
            uf.union(u, v)
        import bisect
        comp_online = {} 
        for station in range(1, c+1):
            root = uf.find(station)
            if root not in comp_online:
                comp_online[root] = []
            comp_online[root].append(station)
        for root in comp_online:
            comp_online[root].sort()
        online = [True] * (c+1)
        res = []
        for typ, x in queries:
            if typ == 1:
                if online[x]:
                    res.append(x)
                else:
                    root = uf.find(x)
                    lst = comp_online.get(root, [])
                    if not lst:
                        res.append(-1)
                    else:
                        res.append(lst[0])
            else: 
                if online[x]:
                    online[x] = False
                    root = uf.find(x)
                    lst = comp_online.get(root)
                    if lst is not None:
                        idx = bisect.bisect_left(lst, x)
                        if idx < len(lst) and lst[idx] == x:
                            lst.pop(idx)
        return res

        