package SocialNetwork;

public class BFS {
    public static void main(String[] args) {
        // Adjacency matrix used to represent the social network
        int[][] graphMatrix = {
                {1, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}};
        GraphTruth graph = new GraphTruth(graphMatrix);

        if (graph.getSize() != 0) {
            int start = 0;
            int target = 5;
            if (!graph.BFS(start, target)) {
                System.out.format("""
                        BFS algorithm couldn't find the distance between nodes %d and %d.
                        There might be a problem with choosing the start and target nodes. Try using nodes in range 0-%d.
                        """, start, target, graph.getSize() - 1);
            }
            else{
                System.out.println("BFS algorithm finished with success.");
            }
        }
    }

}
