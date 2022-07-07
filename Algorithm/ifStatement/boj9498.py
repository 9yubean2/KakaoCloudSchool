#90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F를
score = int(input())
if 90 <=score and score <= 100 :
    print("A")
elif 80 <=score and score <= 89 :
    print("B")
elif 70 <= score and score <= 79:
    print("C")
elif 60 <= score and score <= 69:
    print("D")
else:
    print("F")