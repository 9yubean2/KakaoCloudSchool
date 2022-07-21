
T = int(input())
s = []
for _ in range(T):
    n = int(input())
    if n == 0:
        s.pop()
    else:
        s.append(n)

result = 0
for i in range(len(s)):
    result += s[i]

print(result)


