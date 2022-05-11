import heapq


standard_input = '''3
1 1 5
0 3 0
1 4 0'''


def solve(n):
    global arr
    global heap
    global min
    while(len(heap) > 0):
        (count, (x, y)) = heapq.heappop(heap)
        if count > min:
            break
        if x == n - 1 and y == n - 1:
            if count < min:
                min = count
        elif x == n - 1:
            heapq.heappush(heap, (count + arr[x][y + 1], (x, y + 1)))
        elif y == n - 1:
            heapq.heappush(heap, (count + arr[x + 1][y], (x + 1, y)))
        else:
            heapq.heappush(heap, (count + arr[x + 1][y], (x + 1, y)))
            heapq.heappush(heap, (count + arr[x][y + 1], (x, y + 1)))
    pass

n = int(input())
arr = []
for i in range(n):
    arr.append([n for n in map(int, input().split())])
heap = []
heapq.heapify(heap)
heapq.heappush(heap, (arr[0][0], (0, 0)))
min = 1000000000000000000000000000
solve(n)
print(min)