import sys

T = int(sys.stdin.readline())

for _ in range(T):
    N, K = map(int,sys.stdin.readline().split())
    time = list(map(int,sys.stdin.readline().split()))
    array = [[] for _ in range(N+1)]
    input_deg = [0 for _ in range(N+1)]
    for _ in range(K):
        x, y = map(int,sys.stdin.readline().split())
        array[x].append(y)
        input_deg[y] += 1
    final = int(sys.stdin.readline())
    queue = []
    dp = [0 for _ in range(N+1)]
    for k in range(1 , N+1):
        if input_deg[k] == 0:
            queue.append(k)
            dp[k] = time[k-1]

    while queue:
        temp = queue.pop(0)
        for i in array[temp]:
            input_deg[i] -= 1
            dp[i] = max(dp[i], dp[temp] + time[i - 1])
            if input_deg[i] == 0:
                queue.append(i)

    print(dp[final])










