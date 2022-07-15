s = input()
newS = set(s)
sort = sorted(newS,reverse=False)
stack = []
for s in sort:
    print(s,end='')
