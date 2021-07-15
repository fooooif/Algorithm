import sys

T = int(sys.stdin.readline())

for _ in range(T):
    p = sys.stdin.readline().split()
    n = int(sys.stdin.readline().split())

    array =sys.stdin.readline().strip()[1:-1].split(",")

    for a in p:
        if a == "D":
            if len(array) == 0:
                print("error")
                break
            array.pop(0)
        if a == "R":
            array.reverse()
    print(array)





