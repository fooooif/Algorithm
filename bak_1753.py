import sys
import heapq
V, E = map(int,sys.stdin.readline().split())
start = int(sys.stdin.readline())
hash_map = [100000000]*(V+1)
array_list = [[] for _ in range(V+1)]
for _ in range(E):
    x,y,z = map(int,sys.stdin.readline().split())
    array_list[x].append((y,z))
queue = []
heapq.heappush(queue,[0,start])
hash_map[start] = 0
while queue:
    value,index = heapq.heappop(queue)

    for a,b in array_list[index]:
        if hash_map[a] > value + b:
            heapq.heappush(queue, [value + b,a])
            hash_map[a] = value +b

for value in hash_map[1:]:
    if value == 100000000:
        print("INF")
        continue
    print(value)

