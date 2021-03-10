def print_hi(b1: int, b2: int):
    size = (b1 + 1) * (b2 + 1)
    matrix = [[0 for i in range(size)] for j in range(size)]
    max_b = max(b1, b2)

    for i in range(b1 + 1):
        for j in range(b2 + 1):
            idx = index(max_b, i, j)

            matrix[idx][index(max_b, 0, j)] = 1
            matrix[idx][index(max_b, i, 0)] = 1

            matrix[idx][index(max_b, b1, j)] = 1
            matrix[idx][index(max_b, i, b2)] = 1

            matrix[idx][index(max_b, (i + j) - min(b2, i + j), min(b2, i + j))] = 1
            matrix[idx][index(max_b, min(b1, i + j), (i + j) - min(b1, i + j))] = 1

    for i in range(size):
        matrix[i][i] = 0

    printMatrix(matrix, size)


def printMatrix(matrix: list[list[int]], size: int):
    for i in range(size):
        for j in range(size):
            print(matrix[i][j], end=" ")
        print()


def index(max_b: int, i: int, j: int) -> int:
    return (max_b + 1) * i + j


if __name__ == '__main__':
    bottle1 = 1
    bottle2 = 1
    print_hi(bottle1, bottle2)
