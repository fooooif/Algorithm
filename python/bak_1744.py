import sys

N = int(sys.stdin.readline())

array_pl = []
array_mi = []
answer = 0
for _ in range(N):
    num = int(sys.stdin.readline())
    if num >= 0:
        array_pl.append(num)
    else:
        array_mi.append(num)

array_pl.sort(reverse=True)
array_mi.sort()

for i in range(0,len(array_pl),2):
    if i == len(array_pl) -1:
        if array_pl[i] > 1:
            answer = answer+ array_pl[i]
            array_pl.pop(0)
    if array_pl[i+1] > 1:
        answer = answer + (array_pl(i) * array_pl(i+1))
        array_pl[i] = -1
        array_pl[i+1] = -1
for i in range(0,len(array_mi),2):
    if i == len(array_mi) -1:
        continue
    if array_mi[i+1] < -1:
        answer = answer + (array_mi(i) * array_mi(i+1))
        array_mi[i] = 1
        array_mi[i+1] =1

