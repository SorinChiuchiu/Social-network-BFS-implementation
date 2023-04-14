package socialnetwork;

import exceptionhandling.*;
import lombok.Getter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


// A dedicated class to build and traverse the social network defined by an adjacency matrix
@Getter
public class Graph {
    // Array containing each node and its neighbours. (each friend in the social network and its other friends)
    private ArrayList<Integer>[] socialNetworkMember;
    // number of nodes in the graph. (number of friends in the social network)
    private Integer socialNetworkSize = 0;

    public Graph() {
    }

    public Graph(int[][] networkAdjacencyMatrix) {
        generateGraph(networkAdjacencyMatrix);
    }

    @SneakyThrows
    public void generateGraph(int[][] networkAdjacencyMatrix) {
        // before we initialise the object, we verify if the matrix is correct.
        verifyMatrix(networkAdjacencyMatrix);
        socialNetworkSize = networkAdjacencyMatrix.length;
        socialNetworkMember = new ArrayList[socialNetworkSize];
        // we add the neighbours of each node (person) in the network.
        // each node will have all neighbours so that the graph can be traversed starting from any node
        for (int i = 0; i < socialNetworkSize; i++) {
            socialNetworkMember[i] = new ArrayList<>();
            for (int j = 0; j < socialNetworkSize; j++) {
                if (networkAdjacencyMatrix[i][j] != 0 || networkAdjacencyMatrix[j][i] != 0) {
                    socialNetworkMember[i].add(j);
                }
            }
        }

    }

    // Function used to verify if the adjacency matrix is correct.
    // For a matrix to be correct, it must not have any isolated nodes
    // and one node cannot have a cycle to itself (a person cannot befriend itself)
    private void verifyMatrix(int[][] networkAdjacencyMatrix) throws NodeHasCycleException, NodeIsIsolatedException {
        for (int i = 0; i < networkAdjacencyMatrix.length; i++) {
            boolean noNeighbour = true;
            for (int j = 0; j < networkAdjacencyMatrix.length; j++) {
                if (i == j && networkAdjacencyMatrix[i][j] == 1) {
                    throw new NodeHasCycleException("A node has cycles to itself");
                }
                if (networkAdjacencyMatrix[i][j] == 1 || networkAdjacencyMatrix[j][i] == 1) {
                    noNeighbour = false;
                }
            }
            if (noNeighbour) {
                throw new NodeIsIsolatedException("A node has no neighbours");
            }
        }
    }

    // The function uses a modified version of BFS(Breadth First Search) that also stores the distances between nodes.
    // It stores visited nodes in array visited, so that we don't iterate through cycles in the graph (social network).
    // The function returns the distance between start and target nodes if the target node is reached, without taking
    // into consideration the starting node.
    // If the start node is invalid, or the target is not reached, or the start node is the same as the target node,
    // the function will throw specific exceptions for each case.
    public int BFS(int start, int target) throws InvalidStartException, InvalidTargetException, StartEqualsTargetException, CouldNotFindPathException {
        Queue<Integer> queue = new LinkedList<>(); // used to store the nodes that will be traversed
        ArrayList<Integer> visited = new ArrayList<>();
        Integer[] distances = new Integer[socialNetworkSize]; // stores the distances between starting node and the other nodes

        // verify if start and target nodes are valid or if the start node is the same as the target node. Throws exception otherwise
        if (start < 0 || start > socialNetworkSize - 1) {
            throw new InvalidStartException(socialNetworkSize - 1);
        }
        if (target < 0 || target > socialNetworkSize - 1) {
            throw new InvalidTargetException(socialNetworkSize -1);
        }
        if(start == target)
            throw new StartEqualsTargetException("Starting node is equal to the target node. Try using different nodes.");

        // we add the starting node into each array and into the queue
        distances[start] = 0;
        visited.add(start);
        queue.add(start);

        // while there are nodes in the queue, we search for the target node by adding the unvisited neighbours to the queue,
        // and we calculate the distance between start and rest of the nodes.
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            if (socialNetworkMember[currentNode] != null) {
                for (int neighbour : socialNetworkMember[currentNode]) {
                    if (neighbour == target) {
                        distances[neighbour] = distances[currentNode] + 1;
                        return distances[neighbour];
                    } else if (!visited.contains(neighbour)) {
                        distances[neighbour] = distances[currentNode] + 1;
                        queue.add(neighbour);
                        visited.add(neighbour);
                    }
                }

            }
        }

        // if the distance between the start node and target node is not found, an exception is thrown
        throw new CouldNotFindPathException(start, target);
    }

}
