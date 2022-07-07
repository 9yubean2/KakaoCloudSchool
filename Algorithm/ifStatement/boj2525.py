H,M = map(int,input().split())
time = int(input())
cM = M+time
if cM >= 60:
    cH = H + (cM // 60)
    if cH >= 24:
        print("{} {}".format(cH-24,cM%60))
    else:
        print("{} {}".format(cH,cM%60))
else:
    print("{} {}".format(H, cM))

