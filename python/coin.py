import sys

N , M =map(int,sys.stdin.readline().split())

array = []
dp = [10000] * (M+1)
for _ in range(N):
    index = int(sys.stdin.readline())
    array.append(index)
    dp[index] = 1


for i in range(10000):
    for index in range(len(array)):
        dp[i+array[index]] = min(dp[index] + 1,dp[index])


