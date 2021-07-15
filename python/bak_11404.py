import sys
INF = int(1e9)

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())

graph = [[INF] * (n+1) for _ in range(n+1)]

for _ in range(m):
    x, y, cost = map(int,sys.stdin.readline().split())
    graph[x][y] = min(cost, graph[x][y])

for i in range(1,n+1):
    for st in range(1,n+1):
        for en in range(1,n+1):
            if st != en and en != i:
                graph[st][en] = min(graph[st][en],graph[st][i] + graph[i][en])

for i in range(1,n+1):
    for j in range(1,n+1):
        if graph[i][j] >= INF:
            print(0,end= " ")
        else:
            print(graph[i][j],end= " ")
    print(end = "\n")



