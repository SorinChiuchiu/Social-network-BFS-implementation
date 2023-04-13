package TestUnit;

import static org.junit.Assert.assertEquals;

import SocialNetwork.Graph;
import org.junit.Test;

import java.util.Optional;

public class BFSTest {
    @Test
    public void BFSTruthTestPositive() {
        int[][] gM = {
                {0, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}};
        Graph g = new Graph(gM);
        assertEquals(true, g.BFS(0,5));
    }
    @Test
    public void BFSTruthTestNegativeInvalidTarget() {
        int[][] gM = {
                {0, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}};
        Graph g = new Graph(gM);
        assertEquals(true, g.BFS(0,7));
    }

    @Test
    public void BFSTruthTestPositiveInvalidStart() {
        int[][] gM = {
                {0, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}};
        Graph g = new Graph(gM);
        assertEquals(false, g.BFS(-1,5));
    }
    @Test
    public void GraphHasCyclesInitialisationFailed() {
        int[][] gM = {
                {1, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}};
        Graph g = new Graph(gM);
        int size = g.getSize();
        assertEquals(0, size);
    }
    @Test
    public void GraphHasIsolatedNodesInitialisationFailed() {
        int[][] gM = {
                {0, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        Graph g = new Graph(gM);
        int size = g.getSize();
        assertEquals(0, size);
    }
}
