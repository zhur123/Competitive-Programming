standard_input = '''3
Mollaristan
Auritania
Zizily
'''
t = int(input())
vowels = "aeiouAEIOU"
for i in range(t):
    str = input()
    if str[-1].lower() == 'y':
        print(f'Case #{i + 1}: {str} is ruled by nobody.')
    elif str[-1] in vowels:
        print(f'Case #{i + 1}: {str} is ruled by Alice.')
    else:
        print(f'Case #{i + 1}: {str} is ruled by Bob.')