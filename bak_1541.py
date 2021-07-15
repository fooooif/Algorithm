import sys

# input_string = sys.stdin.readline().strip()
input_string = "055-050+040"
input_list = input_string.split("-")
answer = 0
aa = input_list[0].split("+")
for a in aa:
    answer = answer + int(a)

for input in input_list[1:]:
    st = input.split("+")
    for s in st:
        answer = answer - int(s)
print(answer)








