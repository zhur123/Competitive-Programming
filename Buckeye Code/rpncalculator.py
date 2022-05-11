standard_input = '''8
2
enter
4
enter
6
*
swap
-
'''

n = int(input())
stack = []
for i in range(n):
    stack.append(0)
for i in range(n):
    op = input()
    # print(stack, op)
    if op == '+':
        stack.append(stack.pop(-1) + stack.pop(-1))
    elif op =='-':
        top = stack.pop(-1)
        bot = stack.pop(-1)
        stack.append(bot - top)
    elif op == '*':
        stack.append(stack.pop(-1) * stack.pop(-1))
    elif op == '/':
        top = stack.pop(-1)
        bot = stack.pop(-1)
        stack.append(bot // top)
    elif op == 'swap':
        top = stack.pop(-1)
        bot = stack.pop(-1)
        stack.append(top)
        stack.append(bot)
    elif op == 'enter':
        stack.append(stack[-1])
    else:
        num = int(op)
        if len(stack) == 0:
            stack.append(num)
        else:
            stack[-1] = num
    
print(stack[-1])
