
# Main program for ECE:5330 homework four, Jake Kitzmann

# Class for Bellman-Ford algorithm
class BellmanFord:
    def __init__(self, graph):
        self.graph = graph

    def shortestPaths(self, sink):
        M = [float("Inf")] * self.graph.V
        M[sink - 1] = 0

        paths = [None] * self.graph.V
        paths[sink - 1] = [sink]

        print('Running Shortest Paths...')
        # shortest paths for each node to sink node
        for _ in range(1, self.graph.V - 1):
            for edge in self.graph.edges:
                if M[edge.head - 1] != float("Inf") and M[edge.head - 1] + edge.weight < M[edge.tail - 1]:
                    M[edge.tail - 1] = M[edge.head - 1] + edge.weight # store the weight
                    paths[edge.tail - 1] = paths[edge.head - 1] + [edge.tail] # store the path
                    print(f'Updated node {edge.head} to {M[edge.head - 1]}')

        # Check for negative weight cycles
        for edge in self.graph.edges:
            if M[edge.head - 1] + edge.weight < M[edge.tail - 1]:
                raise Exception('Graph contains a negative weight cycle. Cannot find shortest paths.')
        
        # Reverse each path's order in paths (list is calculated backwards)
        for i in range(len(paths)):
            paths[i] = paths[i][::-1]

        return M, paths

class Graph:
    def __init__(self, V, E, edges_raw):
        self.V = int(V)
        self.E = int(E)
        self.edges_raw = edges_raw
        self.edges = []
        
        for edge in edges_raw:
            edge_components = edge.split(' ')
            # print(edge_components)
            self.edges.append(Edge(tail = int(edge_components[0]), head = int(edge_components[1]), weight = int(edge_components[2])))

    def checkValues(self):
        for edge in self.edges:
            print('')
            print('checking values...')
            print('edge.tail: ', edge.tail)
            print('edge.head: ', edge.head)
            print('edge.weight: ', edge.weight)
            print('types: ', type(edge.tail), type(edge.head), type(edge.weight))

class Edge:
    def __init__(self, tail, head, weight):
        self.tail = tail
        self.head = head
        self.weight = weight


def main():

    while True:
        print('')
        try:
            filename = input("Enter the file name: ")
            with open(filename, 'r') as file:
                file_contents = file.read()
            break
        except FileNotFoundError:
            print("File not found. Please enter a valid file name.")

    print('')
    file_lines = file_contents.split('\n')
    V = file_lines[0].split(' ')[0]
    E = file_lines[0].split(' ')[1]

    edges_raw = file_lines[1:]

    graph = Graph(V=V, E=E, edges_raw=edges_raw)

    # PART A
    while True:
        try:
            source = int(input("Input source node: "))
            break
        except ValueError:
            print("Invalid input. Please enter an integer.")

    while True:
        try:
            sink = int(input("Input sink node: "))
            break
        except ValueError:
            print("Invalid input. Please enter an integer.")

    # graph.checkValues()

    print('')
    print('Graph edges:')
    for edge in graph.edges:
        print(edge.tail, edge.head, edge.weight)

    print('')

    bellmanFord = BellmanFord(graph=graph)
    M, paths = bellmanFord.shortestPaths(sink=sink)

    print('')
    print('Shortest path weights:')
    for i in range(graph.V):
        print(f'Node {i + 1}: {M[i]}')

    print('')
    print('Shortest paths:')
    for i in range(graph.V):
        print(f'Node {i + 1}: {paths[i]}')

    # PART B
    print('')
    print('Weight of shortest path from source to sink:')
    print(M[source - 1])

    # PART C
    print('')
    print('Shortest path from source to sink:')
    print(paths[source - 1])


if __name__ == "__main__":
    main()