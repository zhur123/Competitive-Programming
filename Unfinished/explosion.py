standard_input = """2 3 12
3 2
4 2 3

"""

# standard_input = """1 2 2
# 2
# 1 1

# standard_input = """1 2 2
# 1
# 1 1

# # """
mapUsed = {}
# https://github.com/mpfeifer1/Kattis/blob/master/explosion.cpp
# https://open.kattis.com/contests/nar21practice4/problems/explosion

def hash(mine, enemy, damage):
    return tuple(('x'.join([str(x) for x in mine]), ('x'.join([str(x) for x in enemy])), damage))

# tabulation
def simulate(mine, enemy, damage): 
    # if memorized, use that
    if(hash(mine, enemy, damage) in mapUsed):
        return mapUsed[hash(mine, enemy, damage)]
    
    # if more damage than combined hp, 100% win
    # if enemy all dead, 100% win
    if(sum(mine) + sum(enemy) <= damage or sum(enemy) == 0):
        mapUsed[hash(mine, enemy, damage)] = 1
        return 1

    # if not enough damage to kill enemy, 0% win
    if(sum(enemy) > damage):
        mapUsed[hash(mine, enemy, damage)] = 0
        return 0

    # print(hash(mine, enemy, damage))

    # calculate probability
    probability = []
    for i in range(len(enemy)):
        temp = enemy.copy()
        if(temp[i] == 1):
            temp.pop()
        else:
            temp[i] -= 1
        result = simulate(mine, temp, damage - 1)
        mapUsed[hash(mine, temp, damage - 1)] = result
        # print(hash(mine, temp, damage - 1))
        # print(result)
        probability.append(result)

    for i in range(len(mine)):
        temp = mine.copy()
        if(temp[i] == 1):
            temp.pop()
        else:
            temp[i] -= 1
        result = simulate(temp, enemy, damage - 1)
        mapUsed[hash(temp, enemy, damage - 1)] = result
        # print(hash(temp, enemy, damage - 1))
        # print(result)
        probability.append(result)

    # print(probability)
    # print(sum(probability) / len(probability))

    result = sum(probability) / len(probability)
    mapUsed[hash(mine, enemy, damage)] = result
    return result

n, m, d = [int(x) for x in input().split()]
mine = [int(x) for x in input().split()]
enemy = [int(x) for x in input().split()]

print(simulate(mine, enemy, d))


# n,m,d = map(int, input().split())

# mine = list(map(int, input().split()))
# enemy = list(map(int, input().split()))
