import sys

# str_1 = sys.stdin.readline().strip()
# str_2 = sys.stdin.readline().strip()
str_1 ="qsdferrfgtfsawfsefeesgdtdrgthyytfgfddsdawdwd"
str_2 = "efvs"



str_1_ar = []
str_2_ar = []
for i in str_1:
    str_1_ar.append(i)
for i in str_2:
    str_2_ar.append(i)
cnt =0
t=0
for i in range(len(str_1_ar)):
    for j in range(t,len(str_2_ar)):
        if str_1_ar[i] == str_2_ar[j]:
            cnt = cnt+1
            print(str_1_ar[i])
            t = j+1
            break
print(cnt)
