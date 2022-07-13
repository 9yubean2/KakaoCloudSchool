import collections

s = input().upper()

# 중복 제거해서 리스트에 넣음
li = list(set(s))
# 카운트용 리스트 정의
cnt_li = []

# i = [M, i, s, s, i, s, s, i, p, i]
for i in li:
    # i 리스트 원소가 words에 몇 개 있는지 카운트
    cnt = s.count(i)
    cnt_li.append(cnt)

#  가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력
if cnt_li.count(max(cnt_li)) >= 2:
    print("?")

else:
    # li 리스트 중 cnt_li에서 가장 큰 수의 인덱스를 반환해서
    # li 인덱스 원소의 문자열을 대문자로 출력
    print(li[cnt_li.index(max(cnt_li))].upper())


# #print(s)
# #print(collections.Counter(s).values())
# if max(collections.Counter(s).values()) in collections.Counter(s).values():
#     print("?")
# else:
#     print(max(collections.Counter(s)))
# # if len(max(collections.Counter(s))) >= 2:
# #     print("?")
# # else:
#     print(max(collections.Counter(s)))





