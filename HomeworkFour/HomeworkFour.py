# Main program for ECE:5330 homework four, Jake Kitzmann

class BellmanFord:
    def __init__(self, graph):
        self.graph = graph

    def shortestPaths(self, source, sink):
        
        V = self.graph.V
        E = self.graph.E
        edges = self.graph.edges

        M = []
        successor = []

        for i in range(0, V):
            M.append(float('inf'))
            successor.append('phi')

        M[sink - 1] = 0

        for i in range(1, V - 1):
            for w in range(1, V):
                updated = False
                if()


    

        

class Graph:
    def __init__(self, V, E, edges_raw):
        self.V = int(V)
        self.E = int(E)
        self.edges_raw = edges_raw
        self.edges = []
        
        for edge in edges_raw:
            edge_components = edge.split(' ')
            print(edge_components)
            self.edges.append(Edge(tail = int(edge_components[0]), head = int(edge_components[1]), weight = int(edge_components[2])))



class Edge:
    def __init__(self, tail, head, weight):
        self.tail = tail
        self.head = head
        self.weight = weight


def main():

    filename = input("Enter the file name: ")

    with open(filename, 'r') as file:
        file_contents = file.read()


    file_lines = file_contents.split('\n')
    V = file_lines[0].split(' ')[0]
    E = file_lines[0].split(' ')[1]

    edges_raw = file_lines[1:]

    graph = Graph(V=V, E=E, edges_raw=edges_raw)

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

    bellmanFord = BellmanFord(graph=graph)
    M, successor = bellmanFord.shortestPaths(source=source, sink=sink)

    print(M)
    print(successor)



if __name__ == "__main__":
    main()