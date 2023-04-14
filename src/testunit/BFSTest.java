package testunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import exceptionhandling.*;
import socialnetwork.Graph;
import org.junit.Test;

public class BFSTest {
    //node 0 has a cycle: graphMatrix[0][0] is 1
    @Test(expected = NodeHasCycleException.class)
    public void whenNodeHasCyclesExceptionThrown_AssertionSucceeds() {
        int[][] graphMatrix = {
                {1, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}};
        new Graph(graphMatrix);
    }

    // node 5 has no connection
    @Test(expected = NodeIsIsolatedException.class)
    public void whenNodeIsIsolatedExceptionThrown_AssertionSucceeds() {
        int[][] graphMatrix = {
                {0, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        new Graph(graphMatrix);
    }

    @Test(expected = InvalidStartException.class)
    public void whenStartIsInvalidExceptionThrown_AssertionSucceeds() throws StartEqualsTargetException, InvalidTargetException, InvalidStartException, CouldNotFindPathException {
        int[][] graphMatrix = {
                {0, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}};
        Graph graph = new Graph(graphMatrix);
        int start = -1;
        int target = 4;
        graph.BFS(start, target);
    }

    @Test(expected = InvalidTargetException.class)
    public void whenTargetIsInvalidExceptionThrown_AssertionSucceeds() throws InvalidStartException, InvalidTargetException, StartEqualsTargetException, CouldNotFindPathException {
        int[][] graphMatrix = {
                {0, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}};
        Graph graph = new Graph(graphMatrix);
        int start = 3;
        int target = 7;
        graph.BFS(start, target);
    }

    @Test(expected = StartEqualsTargetException.class)
    public void whenStartEqualsTargetExceptionThrown_AssertionSucceeds() throws InvalidStartException, InvalidTargetException, StartEqualsTargetException, CouldNotFindPathException {
        int[][] graphMatrix = {
                {0, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}};
        Graph graph = new Graph(graphMatrix);
        int start = 4;
        int target = 4;
        graph.BFS(start, target);
    }

    @Test(expected = StartEqualsTargetException.class)
    public void whenStartEqualsTargetExceptionThrown_AssertionFails() throws InvalidStartException, InvalidTargetException, StartEqualsTargetException, CouldNotFindPathException {
        int[][] graphMatrix = {
                {0, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}};
        Graph graph = new Graph(graphMatrix);
        int start = 1;
        int target = 4;
        graph.BFS(start, target);
    }

    @Test(expected = CouldNotFindPathException.class)
    public void whenCouldNotFindPathExceptionThrown_AssertionFails() throws InvalidStartException, InvalidTargetException, StartEqualsTargetException, CouldNotFindPathException {
        int[][] graphMatrix = {
                {0, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}};
        Graph graph = new Graph(graphMatrix);
        int start = 0;
        int target = 4;
        assertEquals(2, graph.BFS(start,target));
    }

    @Test
    public void GraphDistanceResultTestPositive() throws StartEqualsTargetException, InvalidTargetException, InvalidStartException, CouldNotFindPathException {
        int[][] graphMatrix = {
                {0, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}};
        Graph graph = new Graph(graphMatrix);
        assertEquals(2, graph.BFS(0,4));
    }

    @Test
    public void GraphDistanceResultTestNegative() throws StartEqualsTargetException, InvalidTargetException, InvalidStartException, CouldNotFindPathException {
        int[][] graphMatrix = {
                {0, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}};
        Graph graph = new Graph(graphMatrix);
        assertEquals(5, graph.BFS(0,5));
    }
}
