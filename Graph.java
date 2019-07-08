package pathFinder;

import java.util.HashMap;


public class Graph<T_Vertex, T_Info> {
    private HashMap<T_Vertex, HashMap<T_Vertex, EdgeData>> adjacencyList;


    public Graph() {
        adjacencyList = new HashMap<>();
    }
//Adding the vertex to the graph 
    public void addVertex(T_Vertex vertex) {
        if (adjacencyList.containsKey(vertex)) {
            throw new IllegalArgumentException("The vertex is already present in the graph.");
        }
        adjacencyList.put(vertex, new HashMap<>());
    }

    
    //  Checking if the vertex exists in the graph.
    public boolean vertexExists(T_Vertex vertex) {
        return adjacencyList.containsKey(vertex);
    }

    //Checking if the edge exists in the graph.
    public boolean edgeExists(T_Vertex from, T_Vertex to) {
        if (!adjacencyList.containsKey(from) || !adjacencyList.containsKey(to)) {
            return false;
        }
        return adjacencyList.get(from).containsKey(to);
    }

    //Adding a directed edge to the graph. The edge must not exist.
    public void addEdge(T_Vertex from, T_Vertex to, int weight, T_Info info) {
        if (!adjacencyList.containsKey(from) || !adjacencyList.containsKey(to)) {
            throw new IllegalArgumentException("One of the vertices does not exist in the graph.");
        }
        if (edgeExists(from, to)) {
            throw new IllegalArgumentException("The edge already exists in the graph.");
        }
        EdgeData edgeData = new EdgeData(weight, info);
        adjacencyList.get(from).put(to, edgeData);
    }

    //Checking if edge exists or not
    private void checkEdgeExistence(T_Vertex from, T_Vertex to) {
        if (!adjacencyList.containsKey(from) || !adjacencyList.containsKey(to)) {
            throw new IllegalArgumentException("One of the vertices does not exist in the graph.");
        }
        if (!edgeExists(from, to)) {
            throw new IllegalArgumentException("The edge does not exists in the graph.");
        }
    }


    //Get the information associated with the edge.
    
    public T_Info getEdgeInfo(T_Vertex from, T_Vertex to) {
        checkEdgeExistence(from, to);

        return adjacencyList.get(from).get(to).getInfo();
    }

    // Get the edge weight.
     
    public int getEdgeWeight(T_Vertex from, T_Vertex to) {
        checkEdgeExistence(from, to);

        return adjacencyList.get(from).get(to).getWeight();
    }

  // combining the edge weight and the object associated with the edge.
     
    private class EdgeData {
        private int weight;
        private T_Info info;

        private EdgeData(int weight, T_Info info) {
            this.weight = weight;
            this.info = info;
        }

        private int getWeight() {
            return weight;
        }

        private T_Info getInfo() {
            return info;
        }
    }
}
