standard_input = '''3 3
Anna 1
C++ 2
Bob 2
HTML 5
CSS 5
Maria 1
Python 3
Logging 5 10 5 1
C++ 3
WebServer 7 10 7 2
HTML 3
C++ 2
WebChat 10 20 20 2
Python 3
HTML 3
'''
def has_necessary_skill(contributors, role):
    skill, level = role
    print(skill)


def perform_projects_in_order():
    global contributors
    global projects
    q = [projects[0]]
    while(len(q) > 1):
        name, length, score, expire, roleList = q.remove(0)
        for role in roleList:
            has_necessary_skill(contributors, role)

    pass

contributors = []
numContr, numProject = map(int, input().split())
for i in range(numContr):
    person, skills = input().split()
    skillSet = {}
    for j in range(int(skills)):
        name, level = input().split()
        skillSet[name] = int(level)
    contributors.append((person, skillSet))
projects = []
for i in range(numProject):
    name, length, score, expire, roles = input().split()
    roleList = []
    for j in range(int(roles)):
        name, level = input().split()
        roleList.append((name, level))
    projects.append((name, length, score, expire, roleList))

perform_projects_in_order()