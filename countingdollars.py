standard_input = '''4
2
3
4
100
'''

def solve(x):
    if x in dp:
        return dp[x]
    s = solve(x-1)
    s = {}
    for i in range(len(s)):
        list = s.get(i)
    dp[x] = ans
    return s

n = int(input())
dp = dict()
dp[2] = {[1]}
dp[3] = {[3], [1, 1]}
dp[4] = {[4], [2, 1], [0, 2], [1, 0, 1]}
m  = 10**9 + 7
for i in range(n):
    a = int(input())
    ans = solve(a)
    print(ans)
