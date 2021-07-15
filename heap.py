import heapq

a = []

heapq.heappush(a, (5, 10000))
heapq.heappush(a, (4, 330000))
heapq.heappush(a, (3, 4))
heapq.heappush(a, (2, 4))
heapq.heappush(a, (1, 4))

print(heapq.heappop(a))
print(heapq.heappop(a))
print(heapq.heappop(a))
print(heapq.heappop(a))
print(heapq.heappop(a))
