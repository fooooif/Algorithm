import sys

def dfs(array, x, y, visited,cnt):
    global number_A
    if x < 0 or y < 0 or x > C - 1 or y > R - 1 or visited[ord(array[y][x]) - 65] == True:
        return
    cnt = cnt +1
    visited[ord(array[y][x]) - 65] = True
    if number_A < cnt:
        number_A = cnt
    for i in range(len(dir)):
        dfs(array, x + dir[i][0], y + dir[i][1], visited,cnt)
    cnt = cnt -1
    visited[ord(array[y][x]) - 65] = False

R, C = map(int,sys.stdin.readline().split())
array = [[] for _ in range(R)]
dir = [(0,1),(1,0),(-1,0),(0,-1)]
number_A = 1


for j in range(R):
    st = sys.stdin.readline().strip()
    for i in range(C):
        array[j].append(st[i])
visited = [False for _ in range(ord("Z")-64)]
visited[ord(array[0][0]) - 65] = True
for i in range(len(dir)):
    cnt =1
    dfs(array, 0 +dir[i][0], 0+dir[i][1],visited, cnt)

print(number_A)
