import sys

N , M = map(int,sys.stdin.readline().split())

know = list(map(int,sys.stdin.readline().split()))
know_num = -1
know_list =[] #아는 사람

if know[0] == 0:
    know_num = 0
else:
    know_num = know[0]
    know_list = know[1:]
visited = [False] * (N+1)

for i in know_list:
    visited[i] = True


array = [[] for _ in range(M+1)]
for i in range(1,M+1):
    an = False
    pe_num = list(map(int,sys.stdin.readline().split()))
    aa = list()
    for j in range(1,pe_num[0]+1):
        aa.append(pe_num[j])
    array[i] = aa
for _ in range(M):
    for i in range(1, M + 1):
        ans = False
        for node in array[i]:
            if visited[node] == True:
                ans = True
        if ans == True:
            for node in array[i]:
                visited[node] = True


cnt = M

for i in range(1,len(array)):
    for j in range(len(array[i])):
        if visited[array[i][j]] == True:
            cnt -= 1
            break

print(cnt)


