import collections

s = input().upper()
# if max(collections.Counter(s).values()) >= 2:
#     print("?")
# else:
#     print(max(collections.Counter(s)))
for _ in range(len(collections.Counter(s).values())):
    print(max(collections.Counter(s).values()))