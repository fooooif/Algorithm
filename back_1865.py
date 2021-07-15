import sys
def bf(start):
    for i in range(N):
        for j in range(M*2+W):
            pre_node = array_list[j][0]
            next_node = array_list[j][1]
            cost = array_list[j][2]
            if  distance[pre_node] + cost < distance[next_node]:
                distance[next_node] = distance[pre_node] + cost
                if i == N - 1:
                    return True

    return False


TC = int(sys.stdin.readline())

for _ in range(TC):
    N, M, W = map(int, sys.stdin.readline().split())
    array_list = []
    for _ in range(M):
        S, E ,T = map(int, sys.stdin.readline().split())
        array_list.append((S,E,T))
        array_list.append((E,S,T))

    for _ in range(W):
        S, E ,T = map(int, sys.stdin.readline().split())
        array_list.append((S,E,-T))

    distance = [int(1e9)]*(N+1)
    aa = bf(0)
    if aa == True:
        print("YES")
        continue
    print("NO")




