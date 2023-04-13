import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// A dedicated class to build and traverse the social network defined by an adjacency matrix
@Getter
public class Graph {
    // Array containing each node and its neighbours. (each friend in the social network and its other friends)
    private ArrayList<Integer>[] vertex;
    // number of nodes in the graph. (number of friends in the social network)
    private Integer size = 0;

    Graph(int[][] gM) {
        // before we initialise the object, we verify if the matrix is correct.
        if (verifyMatrix(gM)) {
            size = gM.length;
            vertex = new ArrayList[size];
            // we add the neighbours of each vertex.
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (gM[i][j] != 0 || gM[j][i] != 0) {
                        if (vertex[i] == null) vertex[i] = new ArrayList<>();
                        vertex[i].add(j);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(vertex));
    }

    // Function used to verify if the matrix is correct.
    // For a matrix to be correct, it must not have any isolated nodes
    // one node cannot have a cycle to itself (a person cannot befriend itself)
    private boolean verifyMatrix(int[][] gM) {
        for (int i = 0; i < gM.length; i++) {
            boolean noNeighbour = true;
            for (int j = 0; j < gM.length; j++) {
                if (i == j && gM[i][j] == 1) {
                    System.out.println("Node has cycles to itself");
                    return false;
                }
                if (gM[i][j] == 1 || gM[j][i] == 1) {
                    noNeighbour = false;
                }
            }
            if (noNeighbour) {
                System.out.println("A node has no neighbours");
                return false;
            }
        }
        return true;
    }


    // The function uses a modified version of BFS(Breadth First Search) that also stores the distances between nodes.
    // It stores visited nodes in array visited, so that we don't iterate through cycles in the graph (social network).
    // The function returns true if the target node is reached and prints the cost from start to target and returns false
    // if the start node is invalid or the target is not reached.
    public boolean BFS(int start, int target) {
        Queue<Integer> queue = new LinkedList<>(); // used to store the nodes that will be traversed
        ArrayList<Integer> traversal = new ArrayList<>(); // stores the map returned by the BFS algorithm in case target is not found
        ArrayList<Integer> visited = new ArrayList<>();
        Integer[] distances = new Integer[size]; // stores the distances between starting node and the other nodes
        // verify if start node is valid
        try {
            distances[start] = 0;
            visited.add(start);
            queue.add(start);
            traversal.add(start);
        } catch (Exception e) {
            System.out.println("Start node is not valid");
            return false;
        }
        // while there are no nodes in the queue, we search for the target node by adding the unvisited neighbours to the queue
        // and we calculate the distance and the BFS traversal
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            if (vertex[currentNode] != null) {
                for (int neigbour : vertex[currentNode]) {
                    if (neigbour == target) {
                        distances[neigbour] = distances[currentNode] + 1;
                        System.out.println("distance from " + start + " to " + target + " is: " + distances[neigbour]);
                        return true;
                    } else if (!visited.contains(neigbour)) {
                        distances[neigbour] = distances[currentNode] + 1;
                        traversal.add(neigbour);
                        queue.add(neigbour);
                        visited.add(neigbour);
                    }
                }

            }
        }
        System.out.print("BFS traversal of the graph is: ");
        System.out.println(traversal.toString());
        return false;
    }
}