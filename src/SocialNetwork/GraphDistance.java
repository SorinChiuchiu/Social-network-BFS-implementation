package SocialNetwork;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


// Additional class that returns the distance found with BFS algorithm, used for testing.
public class GraphDistance {
    // Array containing each node and its neighbours. (each friend in the social network and its other friends)
    private ArrayList<Integer>[] vertex;
    // number of nodes in the graph. (number of friends in the social network)
    private Integer size;

    public GraphDistance() {
    }

    public GraphDistance(int[][] gM) {
        generateGraph(gM);
    }

    public void generateGraph(int[][] gM) {
        // before we initialise the object, we verify if the matrix is correct.
        size = 0;
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
    }

    // Function used to verify if the matrix is correct.
    // For a matrix to be correct, it must not have any isolated nodes
    // one node cannot have a cycle to itself (a person cannot befriend itself)
    private boolean verifyMatrix(int[][] gM) {
        for (int i = 0; i < gM.length; i++) {
            boolean noNeighbour = true;
            for (int j = 0; j < gM.length; j++) {
                if (gM[i][j] == 1 || gM[j][i] == 1) {
                    noNeighbour = false;
                } else if (i == j && gM[i][j] == 1) {
                    System.out.println("Node has cycles to itself");
                    return false;
                }
            }
            if (noNeighbour) {
                System.out.println("A node has no neighbours");
                return false;
            }
        }
        return true;
    }

    public int BFSDistance(int start, int target) {
        Queue<Integer> queue = new LinkedList<>(); // used to store the nodes that will be traversed
        ArrayList<Integer> traversal = new ArrayList<>(); // stores the map returned by the SocialNetwork.BFS algorithm in case target is not found
        ArrayList<Integer> visited = new ArrayList<>();
        Integer[] distances = new Integer[size]; // stores the distances between starting node and the other nodes
        // verify if start node is valid
        try {
            distances[start] = 0;
            visited.add(start);
            queue.add(start);
            traversal.add(start);
        } catch (Exception e) {
            return -1;
        }
        // while there are no nodes in the queue, we search for the target node by adding the unvisited neighbours to the queue
        // and we calculate the distance and the SocialNetwork.BFS traversal
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            if (vertex[currentNode] != null) {
                for (int neigbour : vertex[currentNode]) {
                    if (neigbour == target) {
                        distances[neigbour] = distances[currentNode] + 1;
                        return distances[neigbour];
                    } else if (!visited.contains(neigbour)) {
                        distances[neigbour] = distances[currentNode] + 1;
                        traversal.add(neigbour);
                        queue.add(neigbour);
                        visited.add(neigbour);
                    }
                }

            }
        }
        System.out.print("SocialNetwork.BFS traversal of the graph is: ");
        System.out.println(traversal.toString());
        return -1;
    }

}
