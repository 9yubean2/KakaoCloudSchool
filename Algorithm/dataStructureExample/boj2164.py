from collections import deque
q = deque()
for i in range(int(input())):
    q.append(i+1)
    i += 1
#print(len(q))


while len(q)>1:
    q.popleft()
    a = q.popleft()
    q.append(a)


print(q[0])