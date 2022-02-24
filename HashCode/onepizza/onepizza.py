standard_input = '''3
2 cheese peppers
0
1 basil
1 pineapple
2 mushrooms tomatoes
1 basil'''
import numpy as np

def count(topping):
    global like
    count = 0
    for pizza in like:
        if topping in pizza:
            count += 1
    return count

c = int(input())
like = []
dislike = []
allTop = set()
for i in range(c):
    li = input().split()
    li.pop(0)
    like.append(li)
    dis = input().split()
    dis.pop(0)
    dislike.append(dis)
    allTop.update(li)
for i in range(len(dislike)):
    if len(dislike[i]) == 1:
        co = count(dislike[i][0])
        if co != 0 and co / c < 0.5 and dislike[i][0] in allTop:
            allTop.remove(dislike[i][0])
        
str = ""
for i in allTop:
    str += i + " "
print(f'{len(allTop)} {str}')