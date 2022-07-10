str = input()
order = [-1 for i in range(26)]
for i in range(len(str)):
    if order[ord(str[i])-97] != -1:
         continue
    else:
        order[ord(str[i])-97] = i
print(*order)
# 1 0 -1 -1 2 -1 -1 -1 -1 4 3 -1 -1 7 5 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
#
# print(bet)



