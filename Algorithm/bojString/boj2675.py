T = int(input())
result = ""
for _ in range(T):
    R, s = map(str,input().split())
    for i in range(len(s)):
        result+=s[i]*int(R)
    print(result)
    result = ""

