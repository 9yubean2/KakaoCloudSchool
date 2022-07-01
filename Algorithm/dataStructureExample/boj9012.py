for _ in range(int(input())):
    stk =[]
    vps = True
    for ch in input():
        if ch =='(':
            stk.append(ch)
        else:
            if stk:
                #len(stk)>0일때 pop
                stk.pop()
            else:
                vps = False
                break
    if stk:
       vps = False

    print('YES' if vps else 'NO')#삼항연산자