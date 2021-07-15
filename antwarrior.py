import sys


N = int(sys.stdin.readline())

array = list(map(int,sys.stdin.readline().split()))

dp = [0] * N

for i in range(N):
    if i == 0:
        dp[i] = array[i]
    if i == 1:
        if dp[0] > array[1]:
            dp[1] = dp[0]
        else:
            dp[1] = array[1]
    if dp[i-2] + array[i] > dp[i-1]:
        dp[i] = dp[i-2] + array[i]
    else:
        dp[i] = dp[i-1]
