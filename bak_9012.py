import sys
def find_answer(st):
    cnt = 0
    for s in st:
        if s == "(":
            cnt += 1
        if s == ")":
            cnt -= 1
        if cnt < 0:
            print("NO")
            return
    if cnt == 0:
        print("YES")
    else:
        print("NO")
T = int(sys.stdin.readline())
# T = 1
for _ in range(T):
    st = sys.stdin.readline().strip()
    # st ="(())())"
    # st = "(((()())()"
    # st = "(()())((()))"
    # st =  "((()()(()))(((())))()"
    # st = "()()()()(()()())()"
    # st =  "(()((())()("
    # st = "(("
    # st = "))"
    # st = "())(()"
    find_answer(st)
