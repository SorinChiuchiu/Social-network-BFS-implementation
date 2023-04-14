package socialnetwork;

public class BFS {
    public static void main(String[] args) {
        // Adjacency matrix used to represent the social network
        int[][] graphMatrix = {
                {0, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}};
        try {
            int start = 0;
            int target = 4;
            Graph g = new Graph(graphMatrix);
            int distance = g.BFS(start, target);
            System.out.format("Distance found between node %d and node %d is: %d", start, target, distance);
        }
        catch (Exception exceptionMessage){
            System.out.println(exceptionMessage);
        }
    }

}
