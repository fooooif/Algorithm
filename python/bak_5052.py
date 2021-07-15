import sys
def find_answer_1(phone_list):
    for i in range(len(phone_list)):
        for j in range(len(phone_list)):
            if i == j:
                continue
            if len(phone_list[i]) > len(phone_list[j]):
                if phone_list[j] == phone_list[i][0:len(phone_list[j])]:
                    print("NO")
                    return
            else:
                if phone_list[i] == phone_list[j][0:len(phone_list[i])]:
                    print("NO")
                    return
    print("YES")

def find_answer_2(phone_list):
    for i in range(len(phone_list) - 1):
        if phone_list[i] == phone_list[i+1][0:len(phone_list[i])]:
            print("NO")
            return
    print("YES")
t = int(sys.stdin.readline())
for _ in range(t):
    n = int(sys.stdin.readline())
    phone_list = []
    for _ in range(n):
        phone_list.append(sys.stdin.readline().strip())
    phone_list.sort()
    find_answer_2(phone_list)







