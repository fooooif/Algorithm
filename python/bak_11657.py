import sys

N, M = map(int,sys.stdin.readline().split())
graph = [] * (M)
array = [int(1e9)] *(N+1)

for _ in range(M):
    x,y, cost = map(int,sys.stdin.readline().split())
    graph.append((x,y,cost))

array[1] = 0
def belman():
    for t in range(N):
        for x, y, cost in graph:
            if array[x] != int(1e9) and array[y] > array[x] + cost:
                array[y] = array[x] + cost
                if t == N - 1:
                    return True
    return False

answer = belman()
if answer == True:
    print(-1)
else:
    for i in range(2, N + 1):
        if array[i] == 1e9:
            print(-1)
        else:
            print(array[i])
