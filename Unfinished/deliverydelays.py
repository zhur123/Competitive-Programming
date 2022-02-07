import heapq


standard_input='''4 4
1 2 2
2 3 4
3 4 1
4 1 2
3
1 4 2
3 3 3
4 3 6
'''
global cost

def dijkstra():
    heap = heapq
    heapq.heappush(heap, ())

n, m = [int(x) for x in input().split()]
adj = []
cost = {}
for i in range(n):
    adj.append([])
for i in range(m):
    u, v, d = [int(x) for x in input().split()]
    u -= 1
    v -= 1
    adj[u].append(v)
    adj[v].append(u)
    cost[(u, v)] = d
    cost[(v, u)] = d

orders = int(input())
begin = []
destination = []
ready = []
for i in range(orders):
    s, u, t = [int(x) for x in input().split()]
    begin.append(s)
    destination.append(u)
    ready.append(t)

    