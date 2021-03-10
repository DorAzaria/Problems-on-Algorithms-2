INF = 999999

def FloydWarshall(matrix: list[list[int]]):
    for k in range(len(matrix)):
        for i in range(len(matrix)):
            for j in range(len(matrix)):

                if matrix[i][j] > matrix[i][k] + matrix[k][j]:
                    matrix[i][j] = matrix[i][k] + matrix[k][j]

    for i in range(len(matrix)):
        for j in range(len(matrix)):
            print(matrix[i][j], end=" ")
        print()


if __name__ == '__main__':
    matrix = [
        [0, INF, -2, INF],
        [4, 0, 3, INF],
        [INF, INF, 0, 2],
        [INF, -1, INF, 0]
    ]
    FloydWarshall(matrix)
