standard_input = '''3
1 2
-10 10
205 468
'''
n = int(input())
for i in range(n):
    a, b = map(int, input().split())
    sum = 0
    for i in range(10**8):
        sum += i
    print(a+b)