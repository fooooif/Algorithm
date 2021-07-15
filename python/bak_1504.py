import sys
import heapq

def dijkstra(start):
    distance = [int(1e9)] * (N + 1)
    distance[start] = 0
    queue =[]
    heapq.heappush(queue,(0,start))

    while len(queue) != 0:
        cost,pre = heapq.heappop(queue)
        if distance[pre] < cost:
            continue
        for en,co in array[pre]:
            if distance[en] > co +cost:
                distance[en] = co + cost
                heapq.heappush(queue,((co+cost),en))
    return distance

N, E = map(int,sys.stdin.readline().split())

array = [[] for _ in range(N+1)]

for _ in range(E):
    st,en,co = map(int,sys.stdin.readline().split())

    array[st].append((en,co))
    array[en].append((st,co))

v1,v2 = map(int,sys.stdin.readline().split())


dis_1 = dijkstra(1)
dis_2 = dijkstra(v1)
dis_3 = dijkstra(v2)


answer = min(dis_1[v1] + dis_2[v2] +dis_3[N],dis_1[v2]+dis_3[v1]+dis_2[N])

if answer >= 1e9:
    print(-1)
else:
    print(answer)