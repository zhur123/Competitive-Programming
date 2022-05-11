standard_input = '''100
'''

# https://math.stackexchange.com/questions/930317/formula-for-counting-ways-to-divide-a-number-of-people-into-separate-groups
def pentagonal(n):
    global dp
    n = int(n)
    if n in dp:
        return dp[n]
    elif n < 0:
        return 0
    else:
        k = 1
        stuff = k * (3 * k - 1) / 2
        count = 0
        while(n >= stuff):
            stuff2 = k * (3 * k + 1) / 2
            number = pentagonal(n - stuff) + pentagonal(n - stuff2)
            if k % 2 == 0:
                count += (-1) * number
            else:
                count += number
            k += 1
            stuff = k * (3 * k - 1) / 2
        dp[n] = count
        return count
n = int(input())
m  = 10**9 + 7
dp = dict()
dp[0] = 1
dp[1] = 1
dp[2] = 2
for i in range(n):
    pentagonal(i)
print((pentagonal(n) - 1) % m)