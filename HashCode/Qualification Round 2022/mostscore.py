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
def find_people(available, roleList):
    global contributors
    people = []
    for role in roleList:
        skill, level = role
        flag = False
        for i in contributors:
            person, skillSet = i
            if (skill in skillSet) and (skillSet[skill] >= level) and (person not in people) and (person in available):
                people.append(person)
                flag = True
                break
        if not flag:
            return []
    return people

def perform_projects_most_score(rewards):
    global contributors
    global projects
    global available
    result = []
    for i in rewards:
        name, index = i
        name, length, score, expire, roleList = projects[index]
        people = find_people(available, roleList)
        for i in people:
            available.remove(i)
        if len(people) != 0:
            result.append((name, people))
    return result

contributors = []
available = set()
numContr, numProject = map(int, input().split())
for i in range(numContr):
    person, skills = input().split()
    skillSet = {}
    for j in range(int(skills)):
        name, level = input().split()
        skillSet[name] = int(level)
    contributors.append((person, skillSet))
    available.add(person)
projects = []
rewards = []
for i in range(numProject):
    project, length, score, expire, roles = input().split()
    roleList = []
    for j in range(int(roles)):
        name, level = input().split()
        roleList.append((name, int(level)))
    projects.append((project, length, score, expire, roleList))
    rewards.append((score, i))
rewards.sort()
result = perform_projects_most_score(rewards)
print(len(result))
for i in result:
    name, people = i
    print(name)
    print(" ".join(people))