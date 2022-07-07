import sys
data = [int(sys.stdin.readline()) for i in range(2)]

if data[0] > 0:
    if data[1] > 0:
        print("1")
    else:
        print("4")
else:
    if data[1] > 0:
        print("2")
    else:
        print("3")




