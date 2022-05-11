standard_input = '''50
'''

n = int(input())
m  = 10**9 + 7
ways = 0
dp = dict()
dp[2] = [[1, 1]]
for i in range(3, n + 1):
    curr = dp[i - 1]
    dp[i] = []
    for j in curr:
        cop = [x for x in j]
        cop.append(1)
        for k in range(len(j)):
            co = [x for x in j]
            co[k] += 1
            dp[i].append(co)
            dp[i].append(cop)
        pass
    pass
    filtered = []
    s = set()
    for j in dp[i]:
        j.sort()
        save = "x".join(str(x) for x in j)
        if save not in s:
            s.add(save)
            filtered.append(j)
    dp[i] = filtered

print(len(dp[n]) % m)