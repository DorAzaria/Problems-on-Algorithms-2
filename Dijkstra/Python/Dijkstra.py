inf = 100000


def dijkstra(src, dest, graph: list[list], matrix: list[list]):
    number_of_nodes = len(matrix)
    visitors = [0 for i in range(len(matrix))]
    previous = [-1 for i in range(len(matrix))]
    distances = [inf for i in range(len(matrix))]

    distances[src] = 0

    current_node = getPriority(distances, visitors)

    while current_node != -1:

        for neighbour in graph[current_node]:
            new_distance = distances[current_node] + matrix[current_node][neighbour]

            if visitors[neighbour] == 0 and distances[neighbour] > new_distance:
                distances[neighbour] = new_distance
                previous[neighbour] = current_node

        visitors[current_node] = 1

        if current_node == dest: break

        current_node = getPriority(distances, visitors)

    print(f"Distances ({src})->({dest}) is: {distances[dest]}")
    current_node = dest
    path = ""

    while current_node != -1:
        path = current_node, "-> ", path
        current_node = previous[current_node]

    path = current_node , path

    print(f"Path is: {path}")


def getPriority(distances, visitors) -> int:
    minValue = inf
    minIndex = inf

    for i in range(len(matrix)):
        if visitors[i] == 0 and minValue > distances[i]:
            minIndex = i
            minValue = i

    return minIndex


if __name__ == '__main__':
    matrix = [[0, 2, inf, inf, inf, inf, inf],
              [2, 0, 2, 5, inf, inf, inf],
              [inf, 2, 0, inf, inf, inf, inf],
              [inf, 5, inf, 0, 7, 5, inf],
              [inf, inf, inf, 7, 0, inf, 2],
              [inf, inf, inf, 5, inf, 0, inf],
              [inf, inf, inf, inf, 2, inf, 0]]

    graph = [[0 for column in range(len(matrix))] for row in range(len(matrix))]

    for i in range(len(matrix)):
        for j in range(len(matrix)):
            if matrix[i][j] != inf:
                graph[i].append(j)

    dijkstra(0, 6, graph, matrix)
