#a, b = map(int, input().split('\\n'))
import sys

data = [int(sys.stdin.readline()) for i in range(2)]
results = 0
for i in range(3):
    a = int(str(data[0]))
    b = int(str(data[1])[-1-i])
    tmp = str(a*b)
    print(tmp)
    if i == 0:
        result = int(f'{tmp:0>6}')
    elif i == 1:
        result = int(f'{tmp:0^6}')
    else:
        result = int(f'{tmp:0<6}')
    results += result
print(results)
