standard_input = '''2
7 3
1 2 3 4 5 6 7
5 10
7 7 7 7 7'''

t = int(input())
for i in range(t):
    n, m = map(int, input().split())
    list = [n for n in map(int, input().split())]
    print(f'Case #{i + 1}: {sum(list) % m}')