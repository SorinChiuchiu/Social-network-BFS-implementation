package TestUnit;

import static org.junit.Assert.assertEquals;

import SocialNetwork.GraphDistance;
import SocialNetwork.GraphTruth;
import org.junit.Test;

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
        GraphTruth g = new GraphTruth(gM);
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
        GraphTruth g = new GraphTruth(gM);
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
        GraphTruth g = new GraphTruth(gM);
        assertEquals(false, g.BFS(-1,5));
    }

    @Test
    public void BFSDistanceTestPositiveInvalidStart() {
        int[][] gM = {
                {0, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}};
        GraphDistance g = new GraphDistance(gM);
        assertEquals(-1, g.BFSDistance(-1,5));
    }
    @Test
    public void BFSDistanceTestPositive() {
        int[][] gM = {
                {0, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}};
        GraphDistance g = new GraphDistance(gM);
        assertEquals(3, g.BFSDistance(0,5));
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
        GraphTruth g = new GraphTruth(gM);
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
        GraphTruth g = new GraphTruth(gM);
        int size = g.getSize();
        assertEquals(0, size);
    }
}
