standard_input = '''3
1 1 5
0 3 0
1 4 0'''


def solve(n):
    global arr
    global dp
    for i in range(n):
        for j in range(n):
            if i == 0 and j == 0:
                dp[0][0] = 1
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
arr = []
dp = []
for i in range(n):
    row = [n for n in map(int, input().split())]
    arr.append(row)
    dp.append(row)
solve(n)
print(dp[n-1][n-1])