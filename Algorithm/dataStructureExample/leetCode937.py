logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
letters, digits = [],[]
for log in logs:
    if log.split()[1].isdigit(): #식별자 뒤에가 숫자인지 아닌지 판별
        digits.append(log)
    else:
        letters.append(log)
letters.sort(key=lambda x : (x.split()[1:],x.split()[0])) #식별자를 제외한 뒤에 문자들을 기준으로 정렬 후순위로는 식별자로 정렬
print(letters + digits)

#['let1 art can', 'let3 art zero', 'let2 own kit dig', 'dig1 8 1 5 1', 'dig2 3 6']

