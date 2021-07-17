import sys
sys.setrecursionlimit(10**7)
N = int(sys.stdin.readline())
array_insert = []
for _ in range(N):
    array_insert.append(int(sys.stdin.readline()))


def quick_sort(array):
    key = array[0]
    left = []
    right = []
    for i in range(1, len(array)):
        if key < array[i]:
            right.append(array[i])
        else:
            left.append(array[i])
    if len(left) > 1:
        left = quick_sort(left)
    if len(right) > 1:
        right = quick_sort(right)

    left.append(key)
    left.extend(right)
    return left
array_insert = quick_sort(array_insert)
for i in array_insert:
    print(i)

array_insert.sort()




