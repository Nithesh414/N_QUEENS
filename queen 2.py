def print_board(b):
    for row in b:
        print(row)
def safe(b, r, c, N):
    for i in range(r):
        if b[i][c] == 1 or c - (r - i) >= 0 and b[i][c - (r - i)] == 1 or ( c + (r - i) < N and b[i][c + (r - i)] == 1):
            return False
    return True
def solve(b, r, N):
    if r == N:
        print_board(b)
        return True
    for c in range(N):
        if safe(b, r, c, N):
            b[r][c] = 1
            if solve(b, r + 1, N):
                return True
            b[r][c] = 0
    return False
N = int(input("Enter number of queens: "))
b = [[0] * N for _ in range(N)]
solve(b, 0, N)
if solve(b, 0, N)!= True:
    print("no solution found")