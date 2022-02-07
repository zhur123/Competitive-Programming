m = (int)(input())
words = {}
dict = dict()
line = input().split(" ")
for i in range(1,line):
    words.add(i)
for i in range(m):
    line = input().split(" ")
    for j in range(1,line):
        if not j in words:
            words.remove(j)
        else:

    for j in range(len(words)):

