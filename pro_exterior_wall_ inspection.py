min_num = 8
def dfs(n,index, array, weak, dist):
    for i in range(index + 1, len(weak)):
        if weak[i] > weak[index]:
            array.append(weak[i] - weak[index])
        else:
            array.append(n-(weak[i]- weak[index]))
        print(array)
        dfs(n,i, array, weak, dist)

    if index == len(weak) - 1:
        cnt = -1
        ans_return = 0
        for i in range(len(array)):
            if array[i] > dist[cnt]:
                ans_return += 1
                cnt -= 1
            else:
                array.clear()
                return min_num
        if min_num > ans_return:
            array.clear()
            return ans_return
def solution(n, weak, dist):

    min_num = 8
    for i in range(len(weak)):
        weak.append(weak[i])
    for i in range(int(len(weak)/2)):
        min_num = dfs(n,0, [], weak[-len(weak)+i:-int(len(weak)/2)+i],dist)
    return min_num
print(solution(12,[1, 5, 6, 10],[1, 2, 3, 4]))

