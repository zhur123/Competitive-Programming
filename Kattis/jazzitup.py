import math

n = (int) (input())
for i in range(2, n):
    if math.sqrt(n * i) % 1 != 0:
        print(i)
        break
