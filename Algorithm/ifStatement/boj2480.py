A,B,C = map(int,input().split())
if A==B:
    if B==C:
        print(A*1000+10000)
    else:
        print(A*100+1000)
else :
    if B==C or A==C:
        print(C*100+1000)
    else:
        print(max(A,B,C)*100)