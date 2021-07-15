import sys
base_str = sys.stdin.readline().strip()
bomb_str = sys.stdin.readline().strip()
stack = []
bomb_stack = []
for a in bomb_str:
    bomb_stack.append(a)
for i in base_str:
    stack.append(i)

    if len(stack) >= len(bomb_str) and i == bomb_str[-1]:
        if stack[len(stack)-len(bomb_str):len(stack)] == bomb_stack:

            for _ in range(len(bomb_str)):
                stack.pop(len(stack)-1)
answer = ""
for a in stack:
    answer = answer + a
if len(answer) == 0:
    print("FRULA")
else:
    print(answer)
