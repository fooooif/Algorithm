import sys

T = int(sys.stdin.readline())
for _ in range(T):
    N = int(sys.stdin.readline())
    dp = [0] * (N + 4)
    dp[1] = 1
    dp[2] = 1
    dp[3] = 1

    for i in range(1, N + 1):
        dp[i + 1] = dp[i + 1] + dp[i]
        dp[i + 2] = dp[i + 2] + dp[i]
        dp[i + 3] = dp[i + 3] + dp[i]
    print(dp[N])
