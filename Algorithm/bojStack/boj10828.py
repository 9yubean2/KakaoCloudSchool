'''
pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 스택에 들어있는 정수의 개수를 출력한다.
empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
'''
import sys

T = int(sys.stdin.readline())
s = []
for i in range(T):
    code = sys.stdin.readline().split()
    if code[0]=='push':
        s.append(code[1])
    elif code[0]=='pop':
        if len(s) > 0:
            print(s.pop())
        else:
            print(-1)
    elif code[0] == 'size':
        print(len(s))
    elif code[0] == 'empty':
        if len(s)>0 :
            print(0)
        else:
            print(1)
    else:
        if len(s) > 0:
            print(s[-1])
        else:
            print(-1)


