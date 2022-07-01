a = 10
b = 0b110 #2진법
c = 0o11 #8진법
d = 0x1A #16진법
e = 10.1 #float
f = 1 + 2j #complex
print(type(a), type(b), type(c), type(d), type(e), type(f))
print(a,b,c,d,e,f)
print(bin(b), oct(c), hex(d))
print(type(bin(b)), type(oct(c)), type(hex(d))) #전부 str
print(int(bin(b),2))
print(b.bit_length()) #이진수로 정수를 나타내는 데 필요한 비트 수를 확인

