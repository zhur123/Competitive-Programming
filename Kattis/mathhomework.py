line = input().split(" ")
b = (int)(line[0])
c = (int)(line[1])
d = (int)(line[2])
l = (int)(line[3])
    
possible = False
for i in range((int)(l/b)+1):
    for j in range((int)(l/c)+1):
        for k in range((int)(l/d)+1):
            if i * b + j * c + k * d == l:
                print(str(i) + " " + str(j) + " " + str(k))
                possible = True
if not possible:
    print("impossible")
