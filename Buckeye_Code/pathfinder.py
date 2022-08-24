standard_input = '''3
1 4 5
2 0 1
3 4 1
'''


def solve(n):
    global arr
    global dp
    for i in range(n):
        for j in range(n):
            if i == 0 and j == 0:
                pass
            elif i == 0:
                dp[i][j] += dp[i][j-1]
            elif j == 0:
                dp[i][j] += dp[i-1][j]
            else:
                above = dp[i-1][j]
                left = dp[i][j-1]
                if(above < left):
                    dp[i][j] += above
                else:
                    dp[i][j] += left

n = int(input())
dp = []
for i in range(n):
    row = [n for n in map(int, input().split())]
    dp.append(row)
solve(n)
print(dp[n-1][n-1])